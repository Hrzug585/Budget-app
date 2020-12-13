--usage: psql -U postgres -h localhost -a -f DB-new.sql

\connect budget_app
INSERT INTO public.accounts (account_name, account_created, account_deleted)
	VALUES 
		('macko', '2020-11-10', NULL),
		('dev account', '2020-11-10', NULL),
		('third_acc', '2020-11-10', NULL);
	
	
INSERT INTO public.default_categories (account_name, account_created, account_deleted)
	VALUES 
		('macko', '2020-11-10', NULL),
		('dev account', '2020-11-10', NULL),
		('third_acc', '2020-11-10', NULL);