import utility.User

trait Operations {
  def addUser(user: User,totalUsers: List[User]): List[User]
  def authenticate(userName: String,password: String,totalUser: List[User]): Int
}
