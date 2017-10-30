CREATE DATABASE IF NOT EXISTS ThirdMeal;

USE ThirdMeal;

-- Account Types
CREATE TABLE IF NOT EXISTS AccountTypes(
	accountTypeKey TINYINT UNSIGNED PRIMARY KEY,
	accountDescription VARCHAR(100)
);

INSERT INTO AccountTypes(accountTypeKey, accountDescription)VALUES
	(0, 'Customer'),
	(1, 'Business Owner')
	ON DUPLICATE KEY UPDATE accountDescription = VALUES(accountDescription);

-- Accounts
CREATE TABLE IF NOT EXISTS Accounts(
	accountKey INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(100),
	email VARCHAR(100),
	accountType TINYINT UNSIGNED,
	FOREIGN KEY (accountType)
		REFERENCES AccountTypes(accountTypeKey)
);

-- User Sessions
CREATE TABLE IF NOT EXISTS UserSessions(
	accountKey INT UNSIGNED,
	-- put some hash here
	userSession VARCHAR(100),
	FOREIGN KEY (accountKey)
		REFERENCES Accounts(accountKey)
);

-- Addresses
CREATE TABLE IF NOT EXISTS Addresses(
	addressKey INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	streetAddress VARCHAR(750),
	city VARCHAR(100),
	stateProvince CHAR(2),
	country VARCHAR(100),
	zip VARCHAR(10)
);

-- Restaurants

-- Menus

-- Orders

