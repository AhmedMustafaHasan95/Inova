-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
	user_id bigserial NOT NULL,
	user_name varchar(255) NOT NULL,
	CONSTRAINT users_pkey PRIMARY KEY (user_id)
);


-- public.post definition

-- Drop table

-- DROP TABLE public.post;

CREATE TABLE public.post (
	post_id bigserial NOT NULL,
	body varchar(255) NOT NULL,
	title varchar(255) NOT NULL,
	user_id int8 NULL,
	avg_rate float8 NOT NULL DEFAULT 0,
	CONSTRAINT post_pkey PRIMARY KEY (post_id),
	CONSTRAINT fk7ky67sgi7k0ayf22652f7763r FOREIGN KEY (user_id) REFERENCES public.users(user_id)
);


-- public.review definition

-- Drop table

-- DROP TABLE public.review;

CREATE TABLE public.review (
	review_id bigserial NOT NULL,
	"comment" varchar(255) NOT NULL,
	rate int2 NULL,
	post_id int8 NULL,
	user_id int8 NULL,
	CONSTRAINT review_pkey PRIMARY KEY (review_id),
	CONSTRAINT fk6cpw2nlklblpvc7hyt7ko6v3e FOREIGN KEY (user_id) REFERENCES public.users(user_id),
	CONSTRAINT fkrl7b0my7pmicpl5l591p7qdu7 FOREIGN KEY (post_id) REFERENCES public.post(post_id)
);