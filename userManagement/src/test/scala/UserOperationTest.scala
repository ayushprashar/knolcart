import functionalities.UserOperations
import org.scalatest.FunSuite
import utility.User

class UserOperationTest extends FunSuite{
  val user = User("ayush","8586009316","passwordyehihai")

  test("The function should add the user to the list")
  assert(UserOperations.addUser("ayush","8586009316","passwordyehihai",List()) == List(user))

  test("The function should avoid addition of an existing user")
  assertThrows(UserOperations.addUser("ayush","8586009316","passwordyehihai",List(user)))

  test("The function should provide a token to user on correct credentials")
  assert(UserOperations.authenticate("ayush","passwordyehihai",List(user)) == "8586009316")

  test("The function should avoid access of a user on wrong credentials")
  assert(UserOperations.authenticate("ayush","randomInput",List(user)) == "Invalid access")
}
