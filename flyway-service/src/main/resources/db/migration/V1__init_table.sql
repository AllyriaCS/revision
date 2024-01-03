DROP TABLE IF EXISTS "public"."answer";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."answer"
(
    "id"            int8 NOT NULL,
    "question_id"   int8 NOT NULL,
    "user_id"       int8 NOT NULL,
    "content"       text NOT NULL,
    "image_url"     text,
    "created_when"  timestamp,
    "created_by"    int8,
    "modified_when" timestamp,
    "modified_by"   int8,
    CONSTRAINT "answer_question_id_fkey" FOREIGN KEY ("question_id") REFERENCES "public"."question" ("id"),
    CONSTRAINT "answer_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES "public"."user" ("id"),
    PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public"."authority";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."authority"
(
    "id"            int8 NOT NULL,
    "name"          varchar,
    "created_when"  timestamp,
    "created_by"    int8,
    "modified_when" timestamp,
    "modified_by"   int8,
    PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public"."category";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."category"
(
    "id"            int8    NOT NULL,
    "name"          varchar NOT NULL,
    "created_when"  timestamp,
    "created_by"    int8,
    "modified_when" timestamp,
    "modified_by"   int8,
    PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public"."memebership";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."memebership"
(
    "id"            int8    NOT NULL,
    "user_id"       int8,
    "level"         varchar NOT NULL,
    "created_when"  timestamp,
    "created_by"    int8,
    "modified_by"   int8,
    "modified_when" timestamp,
    "point"         int8    NOT NULL,
    CONSTRAINT "memebership_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES "public"."user" ("id"),
    PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public"."question";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."question"
(
    "id"            int8 NOT NULL,
    "content"       text NOT NULL,
    "category_id"   int8 NOT NULL,
    "user_id"       int8 NOT NULL,
    "created_when"  timestamp,
    "created_by"    int8,
    "modified_when" timestamp,
    "modified_by"   int8,
    CONSTRAINT "question_category_id_fkey" FOREIGN KEY ("category_id") REFERENCES "public"."category" ("id"),
    CONSTRAINT "question_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES "public"."user" ("id"),
    PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public"."question_tag";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."question_tag"
(
    "question_id"   int8 NOT NULL,
    "tag_id"        int8 NOT NULL,
    "created_when"  timestamp,
    "created_by"    int8,
    "modified_when" timestamp,
    "modified_by"   int8,
    CONSTRAINT "question_tag_question_id_fkey" FOREIGN KEY ("question_id") REFERENCES "public"."question" ("id"),
    CONSTRAINT "question_tag_tag_id_fkey" FOREIGN KEY ("tag_id") REFERENCES "public"."tag" ("id")
);

DROP TABLE IF EXISTS "public"."tag";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."tag"
(
    "id"            int8    NOT NULL,
    "name"          varchar NOT NULL,
    "category_id"   int8,
    "created_when"  timestamp,
    "created_by"    int8,
    "modified_when" timestamp,
    CONSTRAINT "tag_category_id_fkey" FOREIGN KEY ("category_id") REFERENCES "public"."category" ("id"),
    PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public"."user";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."user"
(
    "id"            int8    NOT NULL,
    "username"      varchar NOT NULL,
    "password"      varchar,
    "first_name"    varchar NOT NULL,
    "last_name"     varchar NOT NULL,
    "status"        text    NOT NULL,
    "created_when"  timestamp,
    "created_by"    int8,
    "modified_when" timestamp,
    "modified_by"   int8,
    PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public"."user_authority";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."user_authority"
(
    "user_id"       int8,
    "authority_id"  int8,
    "created_when"  timestamp,
    "created_by"    int8,
    "modified_when" timestamp,
    "modified_by"   int8,
    CONSTRAINT "user_authority_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES "public"."user" ("id"),
    CONSTRAINT "user_authority_authority_id_fkey" FOREIGN KEY ("authority_id") REFERENCES "public"."authority" ("id")
);


















