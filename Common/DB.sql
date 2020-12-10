--usage: psql -U postgres -h localhost -a -f DB-new.sql

-- Database: budget_app
-- DROP DATABASE IF EXISTS budget_app;
--ALTER database budget_app is_template=false;

 DROP database budget_app;
 DROP user "dbUser";

CREATE user "dbUser" WITH ENCRYPTED PASSWORD 'dbPassword';

CREATE DATABASE budget_app
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
	LC_COLLATE = 'English_Australia.1252'
    LC_CTYPE = 'English_Australia.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

GRANT ALL ON DATABASE budget_app TO postgres;
GRANT ALL ON DATABASE budget_app TO "dbUser";

--GRANT TEMPORARY, CONNECT ON DATABASE budget_app TO PUBLIC;
-- GRANT CONNECT ON DATABASE budget_app TO "user" WITH GRANT OPTION;