BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Purchase" (
	"PurchaseID"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"CustomerID"	INTEGER,
	"ProductID"	INTEGER,
	"Cost"	REAL,
	"Tax"	REAL,
	"TotalCost"	REAL,
	"Price"	REAL,
	"Quantity"	INTEGER,
	"Date"	TEXT
);
CREATE TABLE IF NOT EXISTS "Customer" (
	"CustomerID"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"Name"	TEXT,
	"Address"	TEXT,
	"Phone"	TEXT
);
CREATE TABLE IF NOT EXISTS "Products" (
	"ProductID"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"Name"	TEXT,
	"Vendor"	TEXT,
	"Price"	REAL,
	"Quantity"	INTEGER
);
INSERT INTO "Purchase" VALUES (1,1,5,1200.0,216.0,2616.0,1200.0,2,'Sat Oct 05 06:59:53 CDT 2019');
INSERT INTO "Purchase" VALUES (2,2,4,4000.0,360.0,4360.0,1000.0,4,'Sat Oct 05 06:59:53 CDT 2019');
INSERT INTO "Purchase" VALUES (3,3,3,6.0,0.54,6.54,2.0,3,'Sat Oct 05 06:59:53 CDT 2019');
INSERT INTO "Purchase" VALUES (4,4,2,4.0,0.36,4.36,4.0,1,'Sat Oct 05 06:59:53 CDT 2019');
INSERT INTO "Purchase" VALUES (5,5,1,2000.0,180.0,2180.0,1000.0,2,'Sat Oct 05 11:59:53 CDT 2019');
INSERT INTO "Purchase" VALUES (6,1,1,5000.0,150.0,5450.0,1000.0,5,'Tue Oct 08 10:59:53 CDT 2019');
INSERT INTO "Purchase" VALUES (7,2,2,4.0,0.36,4.36,4.0,1,'Tue Oct 08 10:59:53 CDT 2019');
INSERT INTO "Purchase" VALUES (8,3,3,4.0,0.36,4.36,2.0,2,'Tue Oct 08 10:59:53 CDT 2019');
INSERT INTO "Purchase" VALUES (9,4,4,4000.0,360.0,4360.0,1000.0,4,'Tue Oct 08 10:59:53 CDT 2019');
INSERT INTO "Purchase" VALUES (10,5,5,2400.0,216.0,2616.0,1200.0,2,'Tue Oct 08 14:59:53 CDT 2019');

INSERT INTO "Customer" VALUES (1,'Oktavianus Facun Baur','The Social Apartment','334-444-1492');
INSERT INTO "Customer" VALUES (2,'Onyinye Rosemary Asogwa','Samford Apartment','334-444-1493');
INSERT INTO "Customer" VALUES (3,'Abhishek Jariwala','Auburn Housing','334-444-1494');
INSERT INTO "Customer" VALUES (4,'Kripa Shankar Muthukumar','The Vilas Apartment','334-444-1495');
INSERT INTO "Customer" VALUES (5,'Ishita Naresh Joshi','The Beacon','334-444-1496');

INSERT INTO "Products" VALUES (1,'Laptop HP','Helett Packard',1000.0,20);
INSERT INTO "Products" VALUES (2,'Mouse Logitech','Logitech',4.0,10);
INSERT INTO "Products" VALUES (3,'Keyboard','AllVendors',2.0,34);
INSERT INTO "Products" VALUES (4,'Laptop HP','Acer',1000.0,5);
INSERT INTO "Products" VALUES (5,'Mac Book Pro','Mac',1200.0,30);
COMMIT;
