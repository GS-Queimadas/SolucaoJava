INSERT INTO SM_CAUSAS (
    ID_CAUSA,
    CLASSIFICACAO_CAUSA,
    CAUSA_GERAL
) VALUES
    (1, 'Natural',   'Raio'),
    (2, 'Humana',    'Fogueira'),
    (3, 'Acidental', 'Curto circuito'),
    (4, 'Criminosa', 'Incendio proposital'),
    (5, 'Humana',    'Bituca de cigarro'),
    (6, 'Natural',   'Calor extremo'),
    (7, 'Acidental', 'Faisca de maquinario'),
    (8, 'Humana',    'Lixo queimado'),
    (9, 'Criminosa', 'Vandalismo'),
    (10,'Natural',   'Atrito causado pelo vento');


INSERT INTO SM_CLASSES (
    ID_CLASSE,
    DESCRICAO
) VALUES
    ('A', 'Muito pequeno'),
    ('B', 'Pequeno'),
    ('C', 'Medio'),
    ('D', 'Grande'),
    ('E', 'Muito grande'),
    ('F', 'Extremo'),
    ('G', 'Catastrofico');


INSERT INTO SM_INCENDIOS (
    ID_INCENDIO,
    NOME_INCENDIO,
    DT_DESCOBERTA,
    DT_CONTROLE,
    AREA_AFETADA_ACRES,
    SM_CAUSAS_ID_CAUSA,
    SM_CLASSES_ID_CLASSE,
    LATITUDE,
    LONGITUDE,
    ESTADO
) VALUES
    (1,  'Incendio Floresta Norte',   DATE '2022-07-01', DATE '2022-07-03', 150.50, 1, 'A', -10.12, -48.32, 'TO'),
    (2,  'Incendio Serra Azul',       DATE '2022-06-15', DATE '2022-06-18', 210.00, 2, 'B', -16.68, -49.25, 'GO'),
    (3,  'Incendio Chapada Branca',   DATE '2022-08-10', DATE '2022-08-14', 300.75, 3, 'C', -12.97, -38.50, 'BA'),
    (4,  'Incendio Vale da Neblina',  DATE '2023-05-20', DATE '2023-05-22',  45.30, 4, 'D', -19.92, -43.94, 'MG'),
    (5,  'Incendio Morro Vermelho',   DATE '2023-09-01', DATE '2023-09-03',  85.00, 5, 'E', -15.78, -47.93, 'DF'),
    (6,  'Incendio Estacao Seca',     DATE '2023-04-10', DATE '2023-04-12',  60.00, 6, 'F',  -3.73, -38.52, 'CE'),
    (7,  'Incendio Floresta Escura',  DATE '2023-03-05', DATE '2023-03-08', 110.00, 7, 'G',  -1.46, -48.49, 'PA'),
    (8,  'Incendio Zona Leste',       DATE '2024-10-01', DATE '2024-10-05', 200.00, 8, 'G', -25.43, -49.27, 'PR'),
    (9,  'Incendio Pico do Norte',    DATE '2024-11-10', DATE '2024-11-14', 175.00, 9, 'B',  -8.05, -34.88, 'PE'),
    (10, 'Incendio Costeiro',         DATE '2024-12-01', DATE '2024-12-03',  90.00,10, 'D', -16.68, -49.25, 'GO');


INSERT INTO SM_CONDICOES_CLIMATICAS (
    ID_CONDICAO,
    TEMPERATURA,
    UMIDADE,
    VELOCIDADE_VENTO,
    DIRECAO_VENTO,
    SM_INCENDIOS_ID_INCENDIO
) VALUES
    (1,  35.2, 30.5, 15.3, 'NORTE',       1),
    (2,  32.0, 40.0, 10.0, 'LESTE',       2),
    (3,  36.5, 25.0, 20.0, 'SUL',         3),
    (4,  30.0, 50.0,  5.0, 'OESTE',       4),
    (5,  38.0, 28.0, 18.0, 'NORDESTE',    5),
    (6,  34.0, 35.0, 12.0, 'LESTE',       6),
    (7,  33.5, 45.0, 14.0, 'NORTE',       7),
    (8,  31.0, 60.0, 10.0, 'SUDESTE',     8),
    (9,  29.0, 70.0,  7.0, 'CENTRO-OESTE',9),
    (10, 40.0, 20.0, 25.0, 'NORTE',      10);


INSERT INTO SM_ORGAO_ATUACAO (ID_ORGAO_ATUACAO, MUNICIPIO, TIPO_ORGAO, TELEFONE, CEP, RUA, NUMERO, COMPLEMENTO)
VALUES 
(1, 'Palmas', 'Bombeiro', '63988887777', '77000-000', 'Rua A', 100, 'Proximo ao lago'),
(2, 'Rio de Janeiro', 'Defesa Civil', '21988888888', '20000-000', 'Av. Atlantica', 300, 'Proximo ao posto 6'),
(3, 'Salvador', 'Brigada Voluntaria','71999999999', '40000-000', 'Rua do Farol', 50, NULL),
(4, 'Belo Horizonte', 'Bombeiro', '31988889999', '30100-000', 'Av. Amazonas', 1234, NULL),
(5, 'Brasilia', 'Defesa Civil', '61977777777', '70000-000', 'Eixo Monumental', 10, 'Bloco A'),
(6, 'Fortaleza', 'Bombeiro', '85999999999', '60000-000', 'Rua da Praia', 78, NULL),
(7, 'Belem', 'Brigada Voluntaria','91988888888', '66000-000', 'Travessa dos Martires',21, NULL),
(8, 'Curitiba', 'Bombeiro', '41988887777', '80000-000', 'Rua XV de Novembro', 555, NULL),
(9, 'Recife', 'Defesa Civil', '81977778888', '50000-000', 'Av. Boa Viagem', 800, NULL),
(10, 'Goiania', 'Bombeiro', '62999997777', '74000-000', 'Rua 10', 1000, NULL);


INSERT INTO SM_ORGAO_INCENDIO (
    SM_INCENDIOS_ID_INCENDIO,
    SM_ORGAO_ATUACAO_ID_ORGAO,
    DATA_ATUACAO
) VALUES
    (1,  1,  DATE '2022-07-01'),
    (2,  2,  DATE '2022-06-15'),
    (3,  3,  DATE '2022-08-10'),
    (4,  4,  DATE '2023-05-20'),
    (5,  5,  DATE '2023-09-01'),
    (6,  6,  DATE '2023-04-10'),
    (7,  7,  DATE '2023-03-05'),
    (8,  8,  DATE '2024-10-01'),
    (8, 10,  DATE '2024-10-01'),
    (9,  9,  DATE '2024-11-10'),
    (10, 10, DATE '2024-12-01'),
    (1, 10,  DATE '2024-12-01');



INSERT INTO SM_ACAO (
    ID_ACAO,
    DT_RELATORIO,
    RESUMO_OPERACIONAL,
    DIFICULDADES,
    RECOMENDACOES,
    SM_INCENDIOS_ID_INCENDIO
) VALUES
    (1,  DATE '2022-07-04', 'Controle manual e uso de helicopteros',   'Vento forte dificultou acao',     'Necessidade de base local',            1),
    (2,  DATE '2022-06-21', 'Incendio controlado apos chuva',         'Acesso dificil',                   'Investir em drones',                   2),
    (3,  DATE '2022-08-15', 'Trabalho conjunto entre orgaos',         'Area extensa',                     'Aumentar efetivo',                     3),
    (4,  DATE '2023-05-23', 'Incendio contido rapidamente',            'Vento lateral',                    'Mais torres de observacao',            4),
    (5,  DATE '2023-09-04', 'Controle eficiente',                       'Terreno ingreme',                  'Mapeamento detalhado',                 5),
    (6,  DATE '2023-04-13', 'Comunidade ajudou',                        'Falta de equipamentos',            'Capacitacao local',                    6),
    (7,  DATE '2023-03-09', 'Atuacao voluntaria essencial',             'Poucos recursos',                  'Convenios com ONGs',                   7),
    (8,  DATE '2024-10-06', 'Atuacao rapida',                            'Zona urbana densa',                'Sistema de alerta',                    8),
    (9,  DATE '2024-11-15', 'Sem vitimas',                               'Fumaca densa',                     'Equipamentos de protecao',             9),
    (10, DATE '2024-12-04', 'Resgate de animais realizado',             'Distancia da base',                'Bases moveis',                        10);