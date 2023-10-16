# Java Spring Test

This is a project that I did to learn both Java and Spring to make a 
simple web API. It takes in data from a JSON file creates instances
of a classes that I define and sorts them in an ArrayList. It has 
several function that returns a selection of the data in the JSON file,
that is presented via several addresses with the use of REST.

/getAllCarts<br />
Returns the full list of all the carts and all their information.

/getCart<br />
Returns a specific cart based on its ID.

/getCheapestCart <br />
Returns the cart with the lowest total cost.

/getCommonShopper <br />
Returns an ArrayList of the UsersID's that has the same product in
their cart, this based on the ID of the product. 