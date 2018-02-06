package functionalities

import utility.User

object UserOperations extends  Operations {

  override def addUser(username: String,mobileNumber: String,password: String,totalUsers: List[User]): List[User] = {
    if (!totalUsers.exists(_.mobileNumber == mobileNumber)) {
      val user: User = User(username, mobileNumber, password)
      (user :: totalUsers).reverse
    }
    else {
      throw new Exception("User already exists")
    }
  }

  override def authenticate(userName: String,password: String,totalUsers: List[User]): String = {
    totalUsers.filter(_.mobileNumber == userName) match {
      case head::_ if head.password == password => head.mobileNumber
      case Nil => "Invalid access"
    }
  }
}
