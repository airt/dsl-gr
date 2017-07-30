package wheels.airt.dsl.gr.env

trait EnvLike {
  self =>

  type Env
  type EnvContent

  final var content: EnvContent = _

  renew()

  private def dup(implicit tag: reflect.ClassTag[Env]): Env = {
    val env = newEnv
    env.asInstanceOf[this.type].content = self.content
    env
  }

  private def renew() {
    self.content = newContent
  }

  def dupAndRenew()(implicit tag: reflect.ClassTag[Env]): Env = {
    val env = self.dup
    self.renew()
    env
  }

  def newEnv(implicit tag: reflect.ClassTag[Env]): Env =
    tag.runtimeClass.asInstanceOf[Class[Env]].newInstance()

  def newContent: EnvContent

  def show: String = showLines mkString "\n"

  def showLines: Seq[String]

  protected def indent: Int = 2

  protected def showContents(ps: (String, EnvLike)*): Seq[String] =
    ps flatMap { case (label, env) => s"$label {" +: env.showLines.map(" " * indent + _) :+ "}" }

  override def toString: String = content.toString

}
