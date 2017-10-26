# Project Requirements & Analysis

## Team
* Seth Perry
* Sudeep Galgali
* Christina Nguyen

## Title
The Third Meal

## Project Summary
We want to create a website where customers can submit food orders for restaurants. The restaurant owners should be able to create and edit a profile and menus for their restaurants. Customers can create a profile for themselves. The customers should be able to browse the menu, place an order, and select how to pick up and pay for their orders. Once the order is placed, the restaurant owners can view, edit, and complete the order.

## Project Requirements

### Business Requirements

| ID | Requirement | Topic Area | Actor | Priority |
| --- | --- | --- | --- | --- |
| BR001 | Provide options for delivery or store pickup | Orders | Customer | High |
| BR002 | Verify if a customer is genuine | Authentication | Customer | Medium |
| BR003 | Provide an option for payment methods | Orders / Payment | Restaurant owner | High |
| BR004 | Track total number of orders | Orders | Restaurant owner / System | Low |
| BR005 | Track total value of orders | Orders | Restaurant owner / System | High |
| BR006 | Track time to fulfillment | Orders | Restaurant owner / System | Low |

### User Requirements

| ID | Requirement | Topic Area | Actor | Priority |
| --- | --- | --- | --- | --- |
| UR001 | Users should be able to place an order for a specific restaurant | Orders | Customer | High |
| UR002 | Users should be able to see all the current active orders | Orders | Restaurant owner / Customer | High |
| UR003 | Users should be able to add and edit menus for their restaurant | Store | Restaurant owner | High |
| UR004 | Users should be able to cancel an active order | ORders |Customer / Restaurant owner | Medium |
| UR005 | Users should be able to declare if the restaurant is open or closed | Store | Restaurant owner | High |
| UR006 | Users should be able to create and edit their profiles | Profile | Customer / Restaurant owner | High |
| UR007 | Users should be able to view a restaurant profile | Profile | Customer | High |
| UR008 | Users should be able to update order status | OrdersUR | Restaurant owner | High |
| UR009 | Users should be able to search for a restaurant | Store | Customer | High |

### Non-functional Requirements

| ID | Requirement | Topic Area | Priority |
| --- | --- | --- | --- |
| NF001 | Order confirmations should be sent in under 30s | Performance | Medium |
| NF002 | Orders updates (to restaurants) should be accurate to 30s | Performance | Medium |
| NF003 | Accounts should be password-protected | Security | High |
| NF004 | Data access should be well-segregated, allowing for database changes | Maintainabiliity | Medium |
| NF005 | All transactions should be ACID compatible | Reliability | High |
| NF006 | UI should confirm order with customers before sending order to restaurant owners | UX | High |

## Use Cases
**Use Case:** Placing an Order

**ID:** UC001

<<<<<<< HEAD
**Description:**
=======
### Description:
>>>>>>> 2813ec1b905693f1db2b1715e80d7e8b367589be
Customer searches for a restaurant and selects items from its menu. He is charged an amount based on the item prices in the menu. Restaurant owner ensures the items are prepared and then marks the status of the order. The customer then collects the order either from the store or from the delivery agent. 

**Main Success Scenario:**
* Customer selects a restaurant.
* Customer views the restaurant profile and menu.
* Customer selects the desired items from the menu.
* Customer confirms the order.
* The order is viewed by the restaurant owner.
* Restaurant owner changes the status of the order.
* Once the order is ready it is either delivered or stored depending on which option is selected(delivery/store pickup).

**Primary Actor:** Customer

**Supporting Actors:** Restaurant Owner

**Pre-Conditions:**
* Customer must be logged in.
* Restaurant must be marked active by Owner.

**Post-Conditions:**
* Customer gets his order either via delivery or store pickup.
* Customer is charged an amount based on the item prices in the menu.
* Order is marked complete and no longer displayed among active orders in the orders view for the restaurant as well as the customer.

**Failure End Condition:**
* Order is marked cancelled and no longer displayed among active orders in the orders view for the restaurant as well as the customer.
* Customer is not charged any amount and is refunded if previously charged.

**Use Case:** Creating restaurant profile and menu

**ID:** UC002

**Description:**
Restaurant Owner creates an account, adds the details of the restaurant and the menu. 

**Main Success Scenario:**
* Restaurant Manager creates an account or logs in if it already exists
* Restaurant Manager navigates to restaurant profile
* Restaurant Manager selects Create Menu option on the UI
* Restaurant Manager enters the details of the items on the UI 

**Primary Actor:**  Restaurant Manager

**Supporting Actors:**  None

**Pre-Conditions:**
* Restaurant Manager should be logged in.
* Restaurant Profile should exist.

**Post-Conditions:**
* The menu information associated with the restaurant is updated.
* The restaurant manager is shown a success prompt

**Failure End Condition:**
* The menu information associated with the restaurant is not updated
* The restaurant manager is shown a failed prompt

