-- Database: budget_app
DROP DATABASE budget_app;
CREATE DATABASE budget_app
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

GRANT CONNECT ON DATABASE budget_app TO "user" WITH GRANT OPTION;
GRANT ALL ON DATABASE budget_app TO postgres;
GRANT TEMPORARY, CONNECT ON DATABASE budget_app TO PUBLIC;

