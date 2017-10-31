CREATE DATABASE IF NOT EXISTS ThirdMeal;

USE ThirdMeal;

-- Account Types
CREATE TABLE IF NOT EXISTS AccountTypes(
	AccountTypeKey TINYINT UNSIGNED PRIMARY KEY,
	AccountTypeDescription VARCHAR(100) NOT NULL
);

INSERT INTO AccountTypes(AccountTypeKey, AccountTypeDescription)VALUES
	(0, 'Customer'),
	(1, 'Business Owner')
	ON DUPLICATE KEY UPDATE AccountTypeDescription = VALUES(AccountTypeDescription);

-- Accounts
CREATE TABLE IF NOT EXISTS Accounts(
	AccountKey INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Username VARCHAR(100) NOT NULL UNIQUE,
	Email VARCHAR(100) NOT NULL UNIQUE,
	AccountType TINYINT UNSIGNED NOT NULL,
	FOREIGN KEY (AccountType)
		REFERENCES AccountTypes(AccountTypeKey)
);

-- User Sessions
CREATE TABLE IF NOT EXISTS UserSessions(
	AccountKey INT UNSIGNED NOT NULL,
	-- put some hash here
	UserSession VARCHAR(100) NOT NULL,
	FOREIGN KEY (AccountKey)
		REFERENCES Accounts(AccountKey)
);

-- Addresses
CREATE TABLE IF NOT EXISTS Addresses(
	AddressKey INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	AccountKey INT UNSIGNED NOT NULL,
	StreetAddress VARCHAR(750) NOT NULL,
	City VARCHAR(100) NOT NULL,
	StateProvince CHAR(2) NULL,
	Country VARCHAR(100) NOT NULL,
	Zip VARCHAR(10) NULL,
	FOREIGN KEY (AccountKey)
		REFERENCES Accounts(AccountKey)
);

-- PhoneNumbers
CREATE TABLE IF NOT EXISTS PhoneNumbers(
	PhoneNumberKey INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	AccountKey INT UNSIGNED NOT NULL,
	AreaCode CHAR(3) NOT NULL,
	NumberMid CHAR(3) NOT NULL,
	NumberEnd CHAR(4) NOT NULL,
	FOREIGN KEY (AccountKey)
		REFERENCES Accounts(AccountKey)
);

-- Restaurants
CREATE TABLE IF NOT EXISTS Restaurants(
	RestaurantKey INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	AccountKey INT UNSIGNED NOT NULL,
	RestaurantName VARCHAR(100) NOT NULL,
	PhoneNumberKey INT UNSIGNED NULL,
	AddressKey INT UNSIGNED NULL,
	FOREIGN KEY (AccountKey)
		REFERENCES Accounts(AccountKey),
	FOREIGN KEY (PhoneNumberKey)
		REFERENCES PhoneNumbers(PhoneNumberKey),
	FOREIGN KEY (AddressKey)
		REFERENCES Addresses(AddressKey)
);

-- Daily Hours
CREATE TABLE IF NOT EXISTS DailyHours(
	DailyHoursKey INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	AccountKey INT UNSIGNED NOT NULL,
	RestaurantKey INT UNSIGNED NOT NULL,
	DayOfWeek TINYINT NOT NULL,
	StartTime TIME NOT NULL,
	EndTime TIME NOT NULL,
	Closed BIT NOT NULL DEFAULT 0,
	FOREIGN KEY (AccountKey)
		REFERENCES Accounts(AccountKey),
	FOREIGN KEY (RestaurantKey)
		REFERENCES Restaurants(RestaurantKey)
);

-- Menus
CREATE TABLE IF NOT EXISTS Menus(
	MenuKey INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	AccountKey INT UNSIGNED NOT NULL,
	RestaurantKey INT UNSIGNED NOT NULL,
	MenuName VARCHAR(100) NOT NULL,
	FOREIGN KEY (AccountKey)
		REFERENCES Accounts(AccountKey),
	FOREIGN KEY (RestaurantKey)
		REFERENCES Restaurants(RestaurantKey)
);

-- MenuItemTypes
CREATE TABLE IF NOT EXISTS MenuItemTypes(
	MenuItemTypeKey TINYINT UNSIGNED PRIMARY KEY,
	MenuItemTypeDescription VARCHAR(100) NOT NULL
);

INSERT INTO MenuItemTypes(MenuItemTypeKey, MenuItemTypeDescription)VALUES
	(0, 'Appetizer'),
	(1, 'Entree'),
	(2, 'Dessert'),
	(3, 'Beverage')
	ON DUPLICATE KEY UPDATE MenuItemTypeDescription = VALUES(MenuItemTypeDescription);

-- MenuItems
CREATE TABLE IF NOT EXISTS MenuItems(
	MenuItemKey INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	AccountKey INT UNSIGNED NOT NULL,
	MenuKey INT UNSIGNED NOT NULL,
	MenuItemName VARCHAR(100) NOT NULL,
	MenuItemDescription VARCHAR(5000) NULL,
	MenuItemCost DOUBLE NOT NULL,
	MenuItemTypeKey TINYINT UNSIGNED NOT NULL,
	FOREIGN KEY (AccountKey)
		REFERENCES Accounts(AccountKey),
	FOREIGN KEY (MenuKey)
		REFERENCES Menus(MenuKey),
	FOREIGN KEY (MenuItemTypeKey)
		REFERENCES MenuItemTypes(MenuItemTypeKey)
);

-- OrderStatuses
CREATE TABLE IF NOT EXISTS OrderStatuses(
	OrderStatusKey TINYINT UNSIGNED PRIMARY KEY,
	OrderStatusDescription VARCHAR(100) NOT NULL
);

INSERT INTO OrderStatuses(OrderStatusKey, OrderStatusDescription)VALUES
	(0, 'Open'),
	(1, 'In Progress'),
	(2, 'Completed'),
	(3, 'Cancelled')
	ON DUPLICATE KEY UPDATE OrderStatusDescription = VALUES(OrderStatusDescription);

-- Orders
CREATE TABLE IF NOT EXISTS Orders(
	OrderKey INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	AccountKey INT UNSIGNED NOT NULL,
	CreatedTime DATETIME NOT NULL,
	OrderStatusKey TINYINT UNSIGNED NOT NULL,
	FOREIGN KEY (AccountKey)
		REFERENCES Accounts(AccountKey),
	FOREIGN KEY (OrderStatusKey)
		REFERENCES OrderStatuses(OrderStatusKey)
);

-- OrderItems
CREATE TABLE IF NOT EXISTS OrderItems(
	OrderItemKey INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	AccountKey INT UNSIGNED NOT NULL,
	OrderKey INT UNSIGNED NOT NULL,
	MenuItemKey INT UNSIGNED NOT NULL,
	Quantity TINYINT UNSIGNED NOT NULL,
	FOREIGN KEY (AccountKey)
		REFERENCES Accounts(AccountKey),
	FOREIGN KEY (OrderKey)
		REFERENCES Orders(OrderKey),
	FOREIGN KEY (MenuItemKey)
		REFERENCES MenuItems(MenuItemKey)
);

