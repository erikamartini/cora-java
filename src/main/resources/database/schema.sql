
-- =========================================
-- CORA JAVA - ESTRUTURA DO BANCO DE DADOS
-- =========================================

-- TABELA: USUARIO
CREATE TABLE usuario (
    id_usuario INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    telefone VARCHAR(20)
);

-- TABELA: CLIENTE
CREATE TABLE cliente (
    id_cliente INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(150),
    observacoes TEXT,
    id_usuario INTEGER NOT NULL,

    CONSTRAINT fk_cliente_usuario
        FOREIGN KEY (id_usuario)
        REFERENCES usuario(id_usuario),

    CONSTRAINT uq_cliente_id_usuario
        UNIQUE (id_cliente, id_usuario)
);

-- TABELA: AGENDAMENTO
CREATE TABLE agendamento (
    id_agendamento INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    data DATE NOT NULL,
    horario TIME NOT NULL,
    descricao VARCHAR(255),
    status VARCHAR(20) NOT NULL DEFAULT 'PENDENTE',
    id_usuario INTEGER NOT NULL,
    id_cliente INTEGER NOT NULL,

    CONSTRAINT fk_agendamento_cliente_usuario
        FOREIGN KEY (id_cliente, id_usuario)
        REFERENCES cliente(id_cliente, id_usuario),

    CONSTRAINT chk_agendamento_status
        CHECK (status IN (
            'PENDENTE',
            'CONFIRMADO',
            'REALIZADO',
            'CANCELADO',
            'FALTA'
        ))
);

-- ÍNDICES
CREATE INDEX idx_cliente_usuario
    ON cliente(id_usuario);

CREATE INDEX idx_agendamento_usuario
    ON agendamento(id_usuario);

CREATE INDEX idx_agendamento_cliente
    ON agendamento(id_cliente);
