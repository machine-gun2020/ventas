CREATE TABLE clientes (
    id_cliente      BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre         VARCHAR(100) NOT NULL,
    email          VARCHAR(100) UNIQUE NOT NULL,
    telefono       VARCHAR(15),
    direccion      TEXT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE productos (
    id_producto    BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre         VARCHAR(100) NOT NULL,
    descripcion    TEXT,
    precio         DECIMAL(10,2) NOT NULL,
    stock          INT NOT NULL CHECK (stock >= 0),
    categoria      VARCHAR(50),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE pedidos (
    id_pedido      BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_cliente     BIGINT NOT NULL,
    fecha_pedido   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total          DECIMAL(10,2) NOT NULL,
    estado         ENUM('Por Entregar', 'Entregado', 'Devuelto', 'Cancelado') NOT NULL DEFAULT 'Por Entregar',
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

CREATE TABLE detalle_pedidos (
    id_detalle     BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_pedido      BIGINT NOT NULL,
    id_producto    BIGINT NOT NULL,
    cantidad       INT NOT NULL CHECK (cantidad > 0),
    precio_unitario DECIMAL(10,2) NOT NULL,
    subtotal       DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

CREATE TABLE pagos (
    id_pago        BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_pedido      BIGINT NOT NULL,
    fecha_pago     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    monto          DECIMAL(10,2) NOT NULL,
    metodo_pago    ENUM('Tarjeta', 'PayPal', 'Transferencia', 'Efectivo'),
    estado_pago    ENUM('Pendiente', 'Pagado', 'Reembolsado') NOT NULL DEFAULT 'Pendiente',
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido)
);

CREATE TABLE envios (
    id_envio       BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_pedido      BIGINT NOT NULL,
    fecha_envio    TIMESTAMP,
    fecha_entrega  TIMESTAMP,
    estado_envio   ENUM('Pendiente', 'En camino', 'Entregado', 'Devuelto') NOT NULL DEFAULT 'Pendiente',
    guia_rastreo   VARCHAR(50) UNIQUE,
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido)
);

CREATE TABLE devoluciones (
    id_devolucion  BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_pedido      BIGINT NOT NULL,
    id_producto    BIGINT NOT NULL,
    fecha_devolucion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    motivo        TEXT NOT NULL,
    estado_devolucion ENUM('Pendiente', 'Aprobada', 'Rechazada') NOT NULL DEFAULT 'Pendiente',
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

CREATE TABLE reportes_ventas (
    id_reporte     BIGINT PRIMARY KEY AUTO_INCREMENT,
    fecha_inicio   DATE NOT NULL,
    fecha_fin      DATE NOT NULL,
    estado_pedido  ENUM('Por Entregar', 'Entregado', 'Devuelto', 'Cancelado'),
    total_ventas   INT NOT NULL DEFAULT 0,
    total_ingresos DECIMAL(10,2) NOT NULL DEFAULT 0.0,
    total_devoluciones INT NOT NULL DEFAULT 0,
    fecha_generacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);