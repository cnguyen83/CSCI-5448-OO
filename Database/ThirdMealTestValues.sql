USE ThirdMeal;

INSERT INTO Accounts(username, email, accountType)
	VALUES ('test', 'test@test.com', 0);

INSERT INTO UserSessions(accountKey, userSession)
	VALUES (1, 'testing');
	
INSERT INTO Addresses(streetAddress, city, stateProvince, country, zip)
	VALUES ('11 test st', 'boulder', 'CO', 'USA', '11111-1234');