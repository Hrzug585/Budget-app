-- SEQUENCE SETUP
-- account sequence
DROP SEQUENCE IF EXISTS public.account_seq;
CREATE SEQUENCE public.account_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.account_seq
    OWNER TO postgres;

-- category sequence
DROP SEQUENCE IF EXISTS public.category_seq;
CREATE SEQUENCE public.category_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.category_seq
    OWNER TO postgres;

-- expense sequence
DROP SEQUENCE IF EXISTS public.expense_seq;
CREATE SEQUENCE public.expense_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.expense_seq
    OWNER TO postgres;


-- /SEQUENCE SETUP END
-- TABLES SETUP

DROP TABLE IF EXISTS public.accounts;
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
    OWNER to postgres;


-- Table: public.categories

DROP IF EXISTS TABLE public.categories;
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
    OWNER to postgres;

-- Table: public.expenses

DROP TABLE IF EXISTS public.expenses;

CREATE TABLE public.expenses
(
    expense_id integer NOT NULL DEFAULT nextval('expense_seq'::regclass),
    "timestamp" character varying NOT NULL,
    category_id integer NOT NULL,
    account_id integer NOT NULL,
    amount double precision NOT NULL,
    CONSTRAINT expenses_pkey PRIMARY KEY (expense_id),
    CONSTRAINT fkey_category_id FOREIGN KEY (category_id)
        REFERENCES public.categories (category_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
	CONSTRAINT fkey_account_id FOREIGN KEY (account_id)
        REFERENCES public.accounts (account_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.expenses
    OWNER to postgres;
