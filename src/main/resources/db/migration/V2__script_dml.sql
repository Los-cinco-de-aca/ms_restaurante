INSERT INTO public.platos (nombre, precio, plato_id) VALUES ('Alitas de pollo', 18800, 1);
INSERT INTO public.platos (nombre, precio, plato_id) VALUES ('Costillitas de cerdo', 28000, 2);
INSERT INTO public.platos (nombre, precio, plato_id) VALUES ('Nachos', 12800, 3);
INSERT INTO public.platos (nombre, precio, plato_id) VALUES ('Burritos', 25000, 4);
INSERT INTO public.platos (nombre, precio, plato_id) VALUES ('Tacos', 25000, 5);
INSERT INTO public.platos (nombre, precio, plato_id) VALUES ('Quesadillas', 23000, 6);

INSERT INTO public.tipo_usuario (tipo_usuario_id, descripcion) VALUES (1, 'Administrador');
INSERT INTO public.tipo_usuario (tipo_usuario_id, descripcion) VALUES (2, 'Mesero');
INSERT INTO public.tipo_usuario (tipo_usuario_id, descripcion) VALUES (3, 'Cliente');


INSERT INTO public.usuario (usuario_id, email, password, nombre, tipo_usuario) VALUES (1, 'pirincho@gmail.com', '123', 'Pirincho Andres', 3);
INSERT INTO public.usuario (usuario_id, email, password, nombre, tipo_usuario) VALUES (2, 'linda@gmail.com', '987', 'Linda Johana', 2);
INSERT INTO public.usuario (usuario_id, email, password, nombre, tipo_usuario) VALUES (3, 'juan@gmail.com', '654', 'Juan Carlos', 1);
INSERT INTO public.usuario (usuario_id, email, password, nombre, tipo_usuario) VALUES (4, 'pablo@gmail.com', '101', 'Pablo Jose', 3);
