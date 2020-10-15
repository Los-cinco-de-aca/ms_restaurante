CREATE TABLE public.pedido (
    cliente_id integer NOT NULL,
    fecha date,
    mesero_id integer NOT NULL,
    cantidad integer,
    total integer,
    plato_id integer NOT NULL,
    pedido_id integer NOT NULL
);


ALTER TABLE public.pedido OWNER TO woqlyrbntashxi;

CREATE SEQUENCE public.pedido_pedido_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pedido_pedido_id_seq OWNER TO woqlyrbntashxi;

ALTER SEQUENCE public.pedido_pedido_id_seq OWNED BY public.pedido.pedido_id;


CREATE TABLE public.platos (
    nombre character varying(100),
    precio integer,
    plato_id integer NOT NULL
);


CREATE SEQUENCE public.platos_plato_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.platos_plato_id_seq OWNER TO woqlyrbntashxi;

ALTER SEQUENCE public.platos_plato_id_seq OWNED BY public.platos.plato_id;

CREATE TABLE public.tipo_usuario (
    tipo_usuario_id integer NOT NULL,
    descripcion character varying(100)
);

ALTER TABLE public.tipo_usuario OWNER TO woqlyrbntashxi;


CREATE TABLE public.usuario (
    usuario_id integer NOT NULL,
    email character varying(100),
    password character varying(200),
    nombre character varying(100),
    tipo_usuario integer
);


ALTER TABLE public.usuario OWNER TO woqlyrbntashxi;

CREATE SEQUENCE public.usuario_usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_usuario_id_seq OWNER TO woqlyrbntashxi;


ALTER SEQUENCE public.usuario_usuario_id_seq OWNED BY public.usuario.usuario_id;


ALTER TABLE ONLY public.pedido ALTER COLUMN pedido_id SET DEFAULT nextval('public.pedido_pedido_id_seq'::regclass);


ALTER TABLE ONLY public.platos ALTER COLUMN plato_id SET DEFAULT nextval('public.platos_plato_id_seq'::regclass);


ALTER TABLE ONLY public.usuario ALTER COLUMN usuario_id SET DEFAULT nextval('public.usuario_usuario_id_seq'::regclass);


ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (pedido_id);


ALTER TABLE ONLY public.platos
    ADD CONSTRAINT platos_pkey PRIMARY KEY (plato_id);


ALTER TABLE ONLY public.tipo_usuario
    ADD CONSTRAINT tipo_usuario_pkey PRIMARY KEY (tipo_usuario_id);


ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT unique_pedido UNIQUE (pedido_id) INCLUDE (pedido_id);


ALTER TABLE ONLY public.platos
    ADD CONSTRAINT unique_platos UNIQUE (nombre) INCLUDE (nombre);

ALTER TABLE ONLY public.tipo_usuario
    ADD CONSTRAINT unique_tipo_usuario UNIQUE (descripcion) INCLUDE (descripcion);

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT unique_usuario UNIQUE (usuario_id);

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (usuario_id);

CREATE INDEX fki_fk_plato_to_pedido ON public.pedido USING btree (plato_id);


CREATE INDEX fki_fk_tipo_usuario_to_usuario ON public.usuario USING btree (tipo_usuario);


CREATE INDEX fki_fk_usuario_mesero_to_pedido ON public.pedido USING btree (mesero_id);

CREATE INDEX fki_fk_usuario_to_pedido ON public.pedido USING btree (cliente_id);

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT fk_plato_to_pedido FOREIGN KEY (plato_id) REFERENCES public.platos(plato_id);

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT fk_tipo_usuario_to_usuario FOREIGN KEY (tipo_usuario) REFERENCES public.tipo_usuario(tipo_usuario_id);

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT fk_usuario_mesero_to_pedido FOREIGN KEY (mesero_id) REFERENCES public.usuario(usuario_id);

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT fk_usuario_to_pedido FOREIGN KEY (cliente_id) REFERENCES public.usuario(usuario_id);
