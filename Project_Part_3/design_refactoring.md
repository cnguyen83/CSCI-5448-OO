# Project Refactoring

## Team
* Seth Perry
* Sudeep Galgali
* Christina Nguyen

## Title
The Third Meal

## Refactoring

For our refactoring, we simplified our design by removing the key and unique item class that all objects inherited from. We also removed the redundant controllers and repository.

### Template Design Pattern

We refactored our customer and restaurant profile creations to use the Template class. Since both profiles require similar steps (create login, add name, view/edit profile/restaurant), we decided that the template class would be a good structure to follow. Both classes can re-use the same methods at a high level, while individually overriding the methods that they need to customize (particularly the profile versus the restaurant menu).

## Facade Design Pattern

We encapsulated the order class to simplify it for the end user. Since a user only needs to know that they add or remove an item, and not what class type the item is specifically, we can use a facade to hide the details.
