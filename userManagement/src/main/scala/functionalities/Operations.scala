package functionalities

import utility.User

trait Operations {
  def addUser(name: String,mobileNumber: String,password: String,totalUsers: List[User]): List[User]
  def authenticate(userName: String,password: String,totalUser: List[User]): String
}
