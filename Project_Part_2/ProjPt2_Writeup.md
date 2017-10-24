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