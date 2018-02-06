import utility.User

object UserOperations extends  Operations {

  override def addUser(user: User,totalUsers: List[User]): List[User] = {
    (user::totalUsers).reverse
  }

  override def authenticate(userName: String,password: String,totalUsers: List[User]): Int = {
    totalUsers.filter(_.mobileNumber == userName) match {
      case head::_ if head.password == password => head.hashCode()
      case Nil => 0
    }
  }
}
