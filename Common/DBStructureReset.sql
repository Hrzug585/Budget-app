--usage: psql -U postgres -h localhost -a -f DB-new.sql

\connect budget_app

-- SEQUENCE SETUP
-- account sequence
DROP SEQUENCE IF EXISTS public.account_seq CASCADE;
CREATE SEQUENCE public.account_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.account_seq
    OWNER TO "dbUser";

-- category sequence
DROP SEQUENCE IF EXISTS public.category_seq CASCADE;
CREATE SEQUENCE public.category_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.category_seq
    OWNER TO "dbUser";

-- expense sequence
DROP SEQUENCE IF EXISTS public.expense_seq CASCADE;
CREATE SEQUENCE public.expense_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.expense_seq
    OWNER TO "dbUser";
	
-- user sequence
DROP SEQUENCE IF EXISTS public.user_seq CASCADE;
CREATE SEQUENCE public.user_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.user_seq
    OWNER TO "dbUser";


-- /SEQUENCE SETUP END
-- TABLES SETUP

DROP TABLE IF EXISTS public.accounts CASCADE;
CREATE TABLE public.accounts
(
    account_id integer NOT NULL DEFAULT nextval('account_seq'::regclass),
    account_name character varying NOT NULL,
    account_created character varying NOT NULL,
    account_deleted character varying,
    CONSTRAINT sessions_pkey PRIMARY KEY (account_id)
)

TABLESPACE pg_default;
ALTER TABLE public.accounts
    OWNER to "dbUser";


-- Table: public.categories

DROP TABLE IF EXISTS public.categories CASCADE;
CREATE TABLE public.categories
(
    category_id integer NOT NULL DEFAULT nextval('category_seq'::regclass),
    category_name character varying NOT NULL,
    account_id integer NOT NULL,
    CONSTRAINT categories_pkey PRIMARY KEY (category_id),
    CONSTRAINT fkey_account_id FOREIGN KEY (account_id)
        REFERENCES public.accounts (account_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.categories
    OWNER to "dbUser";

-- Table: public.expenses

DROP TABLE IF EXISTS public.expenses;

CREATE TABLE public.expenses
(
    expense_id integer NOT NULL DEFAULT nextval('expense_seq'::regclass),
	name character varying NOT NULL,
    "timestamp" character varying NOT NULL,
    category_id integer NOT NULL,
    account_id integer NOT NULL,
    amount double precision NOT NULL,
    CONSTRAINT expenses_pkey PRIMARY KEY (expense_id),
    CONSTRAINT fkey_category_id FOREIGN KEY (category_id)
        REFERENCES public.categories (category_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT fkey_account_id FOREIGN KEY (account_id)
        REFERENCES public.accounts (account_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.expenses
    OWNER to "dbUser";

-- Table: public.default_categories

DROP TABLE IF EXISTS public.default_categories;
CREATE TABLE public.default_categories
(
    category_id integer NOT NULL DEFAULT nextval('category_seq'::regclass),
    category_name character varying NOT NULL,
    CONSTRAINT default_categories_pkey PRIMARY KEY (category_id)
    )

TABLESPACE pg_default;

ALTER TABLE public.default_categories
    OWNER to "dbUser";
	
	
-- Table: public.users

DROP TABLE IF EXISTS public.users CASCADE;
CREATE TABLE public.users
(
    user_id integer NOT NULL DEFAULT nextval('user_seq'::regclass),
    user_name character varying NOT NULL,
	user_password character varying NOT NULL
)

TABLESPACE pg_default;
ALTER TABLE public.users
    OWNER to "dbUser";

