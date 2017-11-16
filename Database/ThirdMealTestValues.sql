USE ThirdMeal;

SET @accountKey = 0;
SET @addressKey = 0;
SET @phoneNumberKey = 0;
SET @restaurantKey = 0;
SET @menuKey = 0;
SET @menuItemKey = 0;
SET @orderKey = 0;

INSERT INTO Accounts(Username, Email, AccountType)
	VALUES ('test', 'test@test.com', 0);
	
SELECT @accountKey := AccountKey FROM Accounts LIMIT 1;

INSERT INTO UserSessions(AccountKey, UserSession)
	VALUES (@accountKey, 'testing');
	
INSERT INTO Addresses(AccountKey, StreetAddress, City, StateProvince, Country, Zip)
	VALUES (@accountKey, '11 test st', 'boulder', 'CO', 'USA', '11111-1234');
	
SELECT @addressKey := AddressKey FROM Addresses LIMIT 1;
	
INSERT INTO PhoneNumbers(AccountKey, AreaCode, NumberMid, NumberEnd)
	VALUES (@accountKey, '123', '456', '7890');
	
SELECT @phoneNumberKey := PhoneNumberKey FROM PhoneNumbers LIMIT 1;
	
INSERT INTO Restaurants(AccountKey, RestaurantName, PhoneNumberKey, AddressKey)
	VALUES (@accountKey, 'Bobs Restaurant', @addressKey, @phoneNumberKey);
	
SELECT @restaurantKey := RestaurantKey FROM Restaurants LIMIT 1;
	
INSERT INTO DailyHours(AccountKey, RestaurantKey, DayOfWeek, StartTime, EndTime)
	VALUES (@accountKey, @restaurantKey, 5, '08:00:00', '17:00:00');
	
INSERT INTO Menus(AccountKey, RestaurantKey, MenuName)
	VALUES (@accountKey, @restaurantKey, 'Breakfast Menu');
	
SELECT @menuKey := MenuKey FROM Menus LIMIT 1;

INSERT INTO MenuItems(AccountKey, MenuKey, MenuItemName, MenuItemDescription, MenuItemCost, MenuItemTypeKey)
	VALUES (@accountKey, @menuKey, 'Omelet', 'The best around.', 10.00, 2);
	
SELECT @menuItemKey := MenuItemKey FROM MenuItems LIMIT 1;
	
INSERT INTO Orders(AccountKey, CreatedTime, OrderStatusKey)
	VALUES (@accountKey, UTC_TIMESTAMP(), 3);
	
SELECT @orderKey := OrderKey FROM Orders LIMIT 1;

INSERT INTO OrderItems(AccountKey, OrderKey, MenuItemKey, Quantity)
	VALUES(@accountKey, @orderKey, @menuItemKey, 2)