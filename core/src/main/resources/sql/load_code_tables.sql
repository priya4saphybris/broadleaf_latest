--
-- The Archetype is configured with "hibernate.hbm2ddl.auto" value="create-drop" in "persistence.xml".
--
-- This will cause hibernate to populate the database when the application is started by processing the files that
-- were configured in the hibernate.hbm2ddl.import_files property.
--
-- This file is responsible for loading  out-of-box miscellaneous tables
--

-- ???? to do / document me (believe this is for securing pages through the site web.app
INSERT INTO BLC_ROLE (ROLE_ID, ROLE_NAME) VALUES (1,'ROLE_USER');

-- ???? to do / document me
INSERT INTO BLC_ID_GENERATION (ID_TYPE, BATCH_SIZE, BATCH_START, VERSION) VALUES ('org.broadleafcommerce.profile.core.domain.Customer',100,100,1);

-- Sample challenge questions
INSERT INTO BLC_CHALLENGE_QUESTION (QUESTION_ID, QUESTION) VALUES (1,'What is your favorite sports team?');
INSERT INTO BLC_CHALLENGE_QUESTION (QUESTION_ID, QUESTION) VALUES (2,'What was your high school name?');
INSERT INTO BLC_CHALLENGE_QUESTION (QUESTION_ID, QUESTION) VALUES (3,'What was your childhood nickname?'); 
INSERT INTO BLC_CHALLENGE_QUESTION (QUESTION_ID, QUESTION) VALUES (4,'What street did you live on in third grade?');
INSERT INTO BLC_CHALLENGE_QUESTION (QUESTION_ID, QUESTION) VALUES (5,'What is your oldest sibling''s middle name?');
INSERT INTO BLC_CHALLENGE_QUESTION (QUESTION_ID, QUESTION) VALUES (6,'What school did you attend for sixth grade?');
INSERT INTO BLC_CHALLENGE_QUESTION (QUESTION_ID, QUESTION) VALUES (7,'Where does your nearest sibling live?');
INSERT INTO BLC_CHALLENGE_QUESTION (QUESTION_ID, QUESTION) VALUES (8,'What is your youngest brother''s birthday?');
INSERT INTO BLC_CHALLENGE_QUESTION (QUESTION_ID, QUESTION) VALUES (9,'In what city or town was your first job?');

INSERT INTO BLC_COUNTRY_SUB_CAT (COUNTRY_SUB_CAT_ID, NAME) VALUES (20, 'City');

INSERT INTO BLC_COUNTRY (ABBREVIATION, NAME) VALUES ('IN','India');
INSERT INTO BLC_STATE (NAME, ABBREVIATION, COUNTRY) VALUES ('ANDHRA PRADESH','AP','IN');
INSERT INTO BLC_STATE (NAME, ABBREVIATION, COUNTRY) VALUES ('TELANGANA','TS','IN');

INSERT INTO BLC_COUNTRY_SUB (NAME, ABBREVIATION, ALT_ABBREVIATION, COUNTRY, COUNTRY_SUB_CAT) VALUES ('ANAKAPALLI','AKP','AP-AKP','IN',20);
INSERT INTO BLC_COUNTRY_SUB (NAME, ABBREVIATION, ALT_ABBREVIATION, COUNTRY, COUNTRY_SUB_CAT) VALUES ('VISAKAPATNAM','VSKP','AP-VSKP','IN',20);
INSERT INTO BLC_COUNTRY_SUB (NAME, ABBREVIATION, ALT_ABBREVIATION, COUNTRY, COUNTRY_SUB_CAT) VALUES ('HYDERABAD','HYD','TS-HYD','IN',20);
----------------------------------------------------------------------------
-- DEPRECATED --------------------------------------------------------------
----------------------------------------------------------------------------