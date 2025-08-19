Delimiter $$
CREATE PROCEDURE SP_INSERTASALIDA(
    IN p_prestamo date,
    IN p_regreso date,
    IN p_observacion varchar(225),
    IN p_fklibro int(10),
    IN p_fkusuario int(10)
)
BEGIN
    INSERT INTO salida (fecha_salida, fecha_regreso, observarcion,fk_libro,fk_usuario)
    VALUES (p_prestamo, p_regreso, p_observacion,p_fklibro,p_fkusuario);
END $$
Delimiter ;

Delimiter $$
CREATE  PROCEDURE SP_INSERTALIBRO(
    IN p_titulo VARCHAR(255),
    IN p_editorial int(11),
    IN p_anio int(11)
)
BEGIN
    INSERT INTO libro (titulo, editorial, anio)
    VALUES (p_titulo, p_editorial, p_anio);
END

Delimiter ;
Delimiter $$
CREATE  PROCEDURE SP_INSERTAUSUARIO(
        in p_nombre varchar(50),
        in p_direccion varchar(50),
        in p_telefono varchar(20),
        in p_ciudad varchar(50),
        in p_correo varchar (50)
)
Begin 
	insert into usuario (nombre,direccion, telefono,ciudad,correo)
    values (p_nombre, p_direccion, p_telefono, p_ciudad,p_correo);
End
Delimiter ;
