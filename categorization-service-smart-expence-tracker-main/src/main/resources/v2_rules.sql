create table if not exists rule (
id big serial primary key,
user_id uuid not null,
name varchar(128) not null,
priority int not null default 100,
enabled boolean not null default true,
category_code varchar(64) not null,
subcategory_code varchar(64),
merchant_rename varchar(256),
conditions_json jsonb not null,
created_at timestamp not null default now(),
updated_at timestamp not null default now()
);
create index if not exists idx_rule_user_priority on rule(user_id, priority);