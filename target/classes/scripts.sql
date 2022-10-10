DROP TABLE IF EXISTS areas_and_district;
DROP TABLE IF EXISTS districts;
DROP TABLE IF EXISTS areas;


CREATE TABLE areas(
    area_id SERIAL,
	area_code varchar not null,
	area_name varchar(100)not null,
	PRIMARY KEY(area_id)
);

CREATE TABLE districts(
    district_id SERIAL,
	district_code varchar not null,
	district_name varchar(100)not null,
	PRIMARY KEY(district_id)
);




CREATE TABLE areas_and_district(
	area_district_code SERIAL,
    district_id integer not null,
	area_id integer not null,
	temporal boolean DEFAULT false,
	PRIMARY KEY(area_district_code),
	FOREIGN KEY(district_id)REFERENCES districts(district_id)ON DELETE RESTRICT,
	FOREIGN KEY(area_id)REFERENCES areas(area_id)ON DELETE RESTRICT
)




SELECT temporal FROM areas_and_district ad
INNER JOIN
areas ar ON ad.area_id=ar.area_id
INNER JOIN districts d ON d.district_id=ad.district_id
WHERE d.district_name='Koson'

CREATE TABLE areas_and_district(
	area_district_code SERIAL,
    district_id integer not null,
	area_id integer not null,
	temporal boolean DEFAULT false,
	PRIMARY KEY(area_district_code),
	FOREIGN KEY(district_id)REFERENCES districts(district_id)ON DELETE RESTRICT,
	FOREIGN KEY(area_id)REFERENCES areas(area_id)ON DELETE RESTRICT
)