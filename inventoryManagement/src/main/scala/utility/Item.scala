package utility

sealed case class Item(id: Int,name: String,category: String,description: String,rating: Int,price: Float,vendor: Vendor)
case class Vendor(name: String,id: Int,location: String)

