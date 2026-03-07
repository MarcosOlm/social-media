package com.example.social_media.config;

import com.example.social_media.entities.Like;
import com.example.social_media.entities.Post;
import com.example.social_media.entities.User;
import com.example.social_media.repositories.LikeRepository;
import com.example.social_media.repositories.PostRepository;
import com.example.social_media.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LikeRepository likeRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "marcos", "marcos@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u2 = new User(null, "mateus", "mateus@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u3 = new User(null, "joão", "joão@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u4 = new User(null, "ana", "ana@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u5 = new User(null, "carlos", "carlos@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u6 = new User(null, "fernanda", "fernanda@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u7 = new User(null, "lucas", "lucas@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u8 = new User(null, "juliana", "juliana@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u9 = new User(null, "roberto", "roberto@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u10 = new User(null, "patricia", "patricia@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u11 = new User(null, "gabriel", "gabriel@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u12 = new User(null, "rafael", "rafael@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u13 = new User(null, "beatriz", "beatriz@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u14 = new User(null, "thiago", "thiago@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u15 = new User(null, "aline", "aline@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u16 = new User(null, "renato", "renato@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u17 = new User(null, "camila", "camila@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u18 = new User(null, "eduardo", "eduardo@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u19 = new User(null, "leonardo", "leonardo@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u20 = new User(null, "isabela", "isabela@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u21 = new User(null, "bruno", "bruno@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u22 = new User(null, "mariana", "mariana@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u23 = new User(null, "henrique", "henrique@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u24 = new User(null, "laura", "laura@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u25 = new User(null, "vinicius", "vinicius@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u26 = new User(null, "daniela", "daniela@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u27 = new User(null, "gustavo", "gustavo@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u28 = new User(null, "paula", "paula@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u29 = new User(null, "felipe", "felipe@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u30 = new User(null, "carolina", "carolina@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u31 = new User(null, "ricardo", "ricardo@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u32 = new User(null, "sabrina", "sabrina@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u33 = new User(null, "daniel", "daniel@email.com", new BCryptPasswordEncoder().encode("12345"));

        Post p1 = new Post(null, "Estudando Java", Instant.now(), null, null, u2);
        Post p2 = new Post(null, "print('Hello, world')", Instant.now(), null, p1, u1);
        Post p3 = new Post(null, "Estudando rust", Instant.now(), null, null, u3);
        Post p4 = new Post(null, "Hoje passei boa parte do dia estudando Java e revisando conceitos importantes como orientação a objetos, encapsulamento e boas práticas de desenvolvimento.", Instant.now(), null, null, u4);
        Post p5 = new Post(null, "Estou criando uma pequena API utilizando Spring Boot para entender melhor como funcionam controllers, services e repositories.", Instant.now(), null, null, u5);
        Post p6 = new Post(null, "Estudando bastante sobre estruturas de dados em Java, principalmente listas, mapas e conjuntos.", Instant.now(), null, null, u6);
        Post p7 = new Post(null, "Hoje resolvi praticar um pouco de algoritmos para melhorar minha lógica de programação.", Instant.now(), null, null, u7);
        Post p8 = new Post(null, "Passei a manhã inteira lendo documentação sobre Rust e achei muito interessante a forma como a linguagem lida com memória.", Instant.now(), null, null, u8);
        Post p9 = new Post(null, "Comecei a estudar banco de dados e estou aprendendo mais sobre SQL e modelagem de dados.", Instant.now(), null, null, u9);
        Post p10 = new Post(null, "Criando um pequeno projeto pessoal para treinar desenvolvimento full stack usando React no frontend e Spring no backend.", Instant.now(), null, null, u10);
        Post p11 = new Post(null, "Hoje aprendi bastante sobre autenticação usando JWT e como proteger rotas em uma aplicação web.", Instant.now(), null, null, u11);
        Post p12 = new Post(null, "Estudando conceitos de arquitetura de software como MVC, Clean Architecture e separação de responsabilidades.", Instant.now(), null, null, u12);
        Post p13 = new Post(null, "Passei um tempo revisando código antigo e percebi como boas práticas realmente fazem diferença na manutenção.", Instant.now(), null, null, u13);
        Post p14 = new Post(null, "Testando algumas funcionalidades novas em um projeto pessoal para aprender mais sobre APIs REST.", Instant.now(), null, null, u14);
        Post p15 = new Post(null, "Hoje foquei em aprender mais sobre testes automatizados e como eles ajudam a manter a qualidade do software.", Instant.now(), null, null, u15);
        Post p16 = new Post(null, "Explorando bibliotecas novas do ecossistema Java e tentando entender quando vale a pena utilizá-las.", Instant.now(), null, null, u16);
        Post p17 = new Post(null, "Passei algum tempo refatorando código antigo para deixá-lo mais limpo e fácil de entender.", Instant.now(), null, null, u17);
        Post p18 = new Post(null, "Hoje estudei sobre programação assíncrona e como ela pode melhorar a performance de aplicações.", Instant.now(), null, null, u18);
        Post p19 = new Post(null, "Praticando desenvolvimento backend criando endpoints e testando requisições com ferramentas de API.", Instant.now(), null, null, u19);
        Post p20 = new Post(null, "Comecei a estudar containers e achei muito interessante como o Docker facilita o deploy de aplicações.", Instant.now(), null, null, u20);
        Post p21 = new Post(null, "Hoje estou aprendendo mais sobre design patterns e como eles ajudam a organizar melhor o código.", Instant.now(), null, null, u21);
        Post p22 = new Post(null, "Trabalhando em um pequeno projeto de rede social para praticar conceitos de backend.", Instant.now(), null, null, u22);
        Post p23 = new Post(null, "Revisando conceitos de programação funcional e tentando aplicar algumas ideias em Java.", Instant.now(), null, null, u23);
        Post p24 = new Post(null, "Passei a tarde estudando como funciona o gerenciamento de memória em linguagens modernas.", Instant.now(), null, null, u24);
        Post p25 = new Post(null, "Aprendendo mais sobre versionamento de código usando Git e boas práticas de commits.", Instant.now(), null, null, u25);
        Post p26 = new Post(null, "Hoje tentei resolver alguns desafios de programação para melhorar minha habilidade com algoritmos.", Instant.now(), null, null, u26);
        Post p27 = new Post(null, "Estudando um pouco sobre segurança em aplicações web e como evitar vulnerabilidades comuns.", Instant.now(), null, null, u27);
        Post p28 = new Post(null, "Explorando frameworks frontend e comparando diferentes abordagens para construir interfaces.", Instant.now(), null, null, u28);
        Post p29 = new Post(null, "Tentando entender melhor como funciona a comunicação entre frontend e backend.", Instant.now(), null, null, u29);
        Post p30 = new Post(null, "Hoje pratiquei bastante manipulação de dados e transformação de objetos em Java.", Instant.now(), null, null, u30);
        Post p31 = new Post(null, "Criando alguns testes de integração para garantir que minha API esteja funcionando corretamente.", Instant.now(), null, null, u31);
        Post p32 = new Post(null, "Estudando formas de melhorar a organização de projetos grandes utilizando boas práticas.", Instant.now(), null, null, u32);
        Post p33 = new Post(null, "Hoje revisei bastante código antigo e fiz algumas melhorias para deixá-lo mais legível.", Instant.now(), null, null, u33);
        Post p34 = new Post(null, "Hoje passei um bom tempo estudando mais sobre desenvolvimento backend com Java e Spring Boot, tentando entender melhor como estruturar serviços e controllers.", Instant.now(), null, null, u1);
        Post p35 = new Post(null, "Estudando mais profundamente como funciona a comunicação entre frontend e backend utilizando APIs REST.", Instant.now(), null, null, u2);
        Post p36 = new Post(null, "Passei parte do dia revisando conceitos importantes de orientação a objetos e como aplicá-los melhor nos meus projetos.", Instant.now(), null, null, u3);
        Post p37 = new Post(null, "Praticando lógica de programação resolvendo alguns desafios interessantes que encontrei na internet.", Instant.now(), null, null, u4);
        Post p38 = new Post(null, "Hoje dediquei um tempo para estudar mais sobre bancos de dados relacionais e modelagem de dados.", Instant.now(), null, null, u5);
        Post p39 = new Post(null, "Testando algumas novas funcionalidades em um projeto pessoal para melhorar minhas habilidades em desenvolvimento.", Instant.now(), null, null, u6);
        Post p40 = new Post(null, "Aprendendo mais sobre autenticação e autorização utilizando tokens JWT em aplicações web.", Instant.now(), null, null, u7);
        Post p41 = new Post(null, "Explorando um pouco mais o ecossistema do Spring e entendendo como funcionam suas principais anotações.", Instant.now(), null, null, u8);
        Post p42 = new Post(null, "Refatorando algumas partes de código antigo para deixá-las mais limpas e organizadas.", Instant.now(), null, null, u9);
        Post p43 = new Post(null, "Estudando conceitos de arquitetura de software para melhorar a organização dos meus projetos.", Instant.now(), null, null, u10);
        Post p44 = new Post(null, "Hoje resolvi revisar alguns conceitos fundamentais de programação para fortalecer a base.", Instant.now(), null, null, u11);
        Post p45 = new Post(null, "Praticando manipulação de dados em Java para entender melhor coleções e streams.", Instant.now(), null, null, u12);
        Post p46 = new Post(null, "Estudando novas ferramentas que podem ajudar no desenvolvimento e na produtividade.", Instant.now(), null, null, u13);
        Post p47 = new Post(null, "Aprendendo mais sobre testes automatizados e a importância deles para manter a qualidade do código.", Instant.now(), null, null, u14);
        Post p48 = new Post(null, "Criando pequenos experimentos para entender melhor alguns conceitos avançados da linguagem.", Instant.now(), null, null, u15);
        Post p49 = new Post(null, "Hoje dediquei um tempo para estudar mais sobre deploy e como publicar aplicações.", Instant.now(), null, null, u16);
        Post p50 = new Post(null, "Explorando ferramentas modernas de desenvolvimento e tentando entender quando utilizá-las.", Instant.now(), null, null, u17);
        Post p51 = new Post(null, "Aprendendo mais sobre containers e como eles ajudam na padronização do ambiente.", Instant.now(), null, null, u18);
        Post p52 = new Post(null, "Estudando conceitos importantes de segurança em aplicações web.", Instant.now(), null, null, u19);
        Post p53 = new Post(null, "Praticando desenvolvimento backend criando alguns endpoints simples.", Instant.now(), null, null, u20);
        Post p54 = new Post(null, "Hoje resolvi estudar um pouco mais sobre estruturas de dados.", Instant.now(), null, null, u21);
        Post p55 = new Post(null, "Criando pequenos scripts para automatizar algumas tarefas do dia a dia.", Instant.now(), null, null, u22);
        Post p56 = new Post(null, "Aprendendo mais sobre boas práticas de organização de projetos.", Instant.now(), null, null, u23);
        Post p57 = new Post(null, "Estudando formas de melhorar a performance de aplicações.", Instant.now(), null, null, u24);
        Post p58 = new Post(null, "Praticando leitura de código para entender diferentes estilos de programação.", Instant.now(), null, null, u25);
        Post p59 = new Post(null, "Hoje resolvi explorar algumas bibliotecas novas.", Instant.now(), null, null, u26);
        Post p60 = new Post(null, "Tentando melhorar minhas habilidades resolvendo exercícios de programação.", Instant.now(), null, null, u27);
        Post p61 = new Post(null, "Estudando como funcionam alguns padrões de projeto.", Instant.now(), null, null, u28);
        Post p62 = new Post(null, "Refatorando código antigo para torná-lo mais legível.", Instant.now(), null, null, u29);
        Post p63 = new Post(null, "Aprendendo mais sobre integração entre diferentes serviços.", Instant.now(), null, null, u30);
        Post p64 = new Post(null, "Praticando desenvolvimento de APIs REST.", Instant.now(), null, null, u31);
        Post p65 = new Post(null, "Estudando documentação de algumas bibliotecas.", Instant.now(), null, null, u32);
        Post p66 = new Post(null, "Testando novas ideias em um pequeno projeto pessoal.", Instant.now(), null, null, u33);
        Post p67 = new Post(null, "Continuando os estudos sobre desenvolvimento backend e boas práticas.", Instant.now(), null, null, u1);
        Post p68 = new Post(null, "Praticando integração entre diferentes camadas da aplicação.", Instant.now(), null, null, u2);
        Post p69 = new Post(null, "Explorando novas formas de organizar código em projetos grandes.", Instant.now(), null, null, u3);
        Post p70 = new Post(null, "Revisando conceitos importantes de programação.", Instant.now(), null, null, u4);
        Post p71 = new Post(null, "Estudando mais sobre APIs e comunicação HTTP.", Instant.now(), null, null, u5);
        Post p72 = new Post(null, "Criando novos experimentos com Java.", Instant.now(), null, null, u6);
        Post p73 = new Post(null, "Aprendendo mais sobre testes unitários.", Instant.now(), null, null, u7);
        Post p74 = new Post(null, "Estudando arquitetura de microsserviços.", Instant.now(), null, null, u8);
        Post p75 = new Post(null, "Praticando manipulação de dados.", Instant.now(), null, null, u9);
        Post p76 = new Post(null, "Refatorando código para melhorar organização.", Instant.now(), null, null, u10);
        Post p77 = new Post(null, "Aprendendo mais sobre banco de dados.", Instant.now(), null, null, u11);
        Post p78 = new Post(null, "Praticando desenvolvimento web.", Instant.now(), null, null, u12);
        Post p79 = new Post(null, "Explorando novas ferramentas.", Instant.now(), null, null, u13);
        Post p80 = new Post(null, "Estudando design patterns.", Instant.now(), null, null, u14);
        Post p81 = new Post(null, "Testando novos recursos da linguagem.", Instant.now(), null, null, u15);
        Post p82 = new Post(null, "Praticando lógica de programação.", Instant.now(), null, null, u16);
        Post p83 = new Post(null, "Estudando integração de sistemas.", Instant.now(), null, null, u17);
        Post p84 = new Post(null, "Aprendendo mais sobre deploy.", Instant.now(), null, null, u18);
        Post p85 = new Post(null, "Explorando boas práticas de desenvolvimento.", Instant.now(), null, null, u19);
        Post p86 = new Post(null, "Praticando criação de APIs.", Instant.now(), null, null, u20);
        Post p87 = new Post(null, "Estudando estruturas de dados.", Instant.now(), null, null, u21);
        Post p88 = new Post(null, "Testando novas bibliotecas.", Instant.now(), null, null, u22);
        Post p89 = new Post(null, "Refatorando partes antigas do projeto.", Instant.now(), null, null, u23);
        Post p90 = new Post(null, "Aprendendo mais sobre organização de código.", Instant.now(), null, null, u24);
        Post p91 = new Post(null, "Estudando comunicação entre serviços.", Instant.now(), null, null, u25);
        Post p92 = new Post(null, "Explorando ferramentas modernas.", Instant.now(), null, null, u26);
        Post p93 = new Post(null, "Praticando desenvolvimento backend.", Instant.now(), null, null, u27);
        Post p94 = new Post(null, "Aprendendo mais sobre segurança.", Instant.now(), null, null, u28);
        Post p95 = new Post(null, "Criando pequenos testes.", Instant.now(), null, null, u29);
        Post p96 = new Post(null, "Explorando diferentes estilos de código.", Instant.now(), null, null, u30);
        Post p97 = new Post(null, "Estudando mais sobre APIs.", Instant.now(), null, null, u31);
        Post p98 = new Post(null, "Praticando manipulação de objetos.", Instant.now(), null, null, u32);
        Post p99 = new Post(null, "Revisando conceitos importantes.", Instant.now(), null, null, u33);
        Post p100 = new Post(null, "Aprendendo novas abordagens de desenvolvimento.", Instant.now(), null, null, u1);
        Post p101 = new Post(null, "Praticando criação de endpoints.", Instant.now(), null, null, u2);
        Post p102 = new Post(null, "Estudando documentação técnica.", Instant.now(), null, null, u3);
        Post p103 = new Post(null, "Explorando boas práticas.", Instant.now(), null, null, u4);
        Post p104 = new Post(null, "Criando pequenos experimentos.", Instant.now(), null, null, u5);
        Post p105 = new Post(null, "Praticando leitura de código.", Instant.now(), null, null, u6);
        Post p106 = new Post(null, "Estudando integração com banco.", Instant.now(), null, null, u7);
        Post p107 = new Post(null, "Refatorando partes da aplicação.", Instant.now(), null, null, u8);
        Post p108 = new Post(null, "Aprendendo novas bibliotecas.", Instant.now(), null, null, u9);
        Post p109 = new Post(null, "Explorando ferramentas de desenvolvimento.", Instant.now(), null, null, u10);
        Post p110 = new Post(null, "Estudando padrões de projeto.", Instant.now(), null, null, u11);
        Post p111 = new Post(null, "Praticando algoritmos.", Instant.now(), null, null, u12);
        Post p112 = new Post(null, "Aprendendo mais sobre arquitetura.", Instant.now(), null, null, u13);
        Post p113 = new Post(null, "Criando novos testes.", Instant.now(), null, null, u14);
        Post p114 = new Post(null, "Explorando novas ideias.", Instant.now(), null, null, u15);
        Post p115 = new Post(null, "Estudando backend moderno.", Instant.now(), null, null, u16);
        Post p116 = new Post(null, "Praticando desenvolvimento.", Instant.now(), null, null, u17);
        Post p117 = new Post(null, "Explorando frameworks.", Instant.now(), null, null, u18);
        Post p118 = new Post(null, "Aprendendo mais sobre APIs.", Instant.now(), null, null, u19);
        Post p119 = new Post(null, "Praticando refatoração.", Instant.now(), null, null, u20);
        Post p120 = new Post(null, "Estudando comunicação HTTP.", Instant.now(), null, null, u21);
        Post p121 = new Post(null, "Explorando boas práticas.", Instant.now(), null, null, u22);
        Post p122 = new Post(null, "Criando pequenos projetos.", Instant.now(), null, null, u23);
        Post p123 = new Post(null, "Aprendendo mais sobre testes.", Instant.now(), null, null, u24);
        Post p124 = new Post(null, "Estudando integração de serviços.", Instant.now(), null, null, u25);
        Post p125 = new Post(null, "Praticando desenvolvimento web.", Instant.now(), null, null, u26);
        Post p126 = new Post(null, "Explorando bibliotecas novas.", Instant.now(), null, null, u27);
        Post p127 = new Post(null, "Aprendendo sobre segurança.", Instant.now(), null, null, u28);
        Post p128 = new Post(null, "Criando endpoints novos.", Instant.now(), null, null, u29);
        Post p129 = new Post(null, "Praticando arquitetura.", Instant.now(), null, null, u30);
        Post p130 = new Post(null, "Estudando organização de projetos.", Instant.now(), null, null, u31);
        Post p131 = new Post(null, "Explorando padrões.", Instant.now(), null, null, u32);
        Post p132 = new Post(null, "Praticando novas abordagens.", Instant.now(), null, null, u33);
        Post p133 = new Post(null, "Continuando os estudos e experimentando novas ideias de desenvolvimento.", Instant.now(), null, null, u1);

        Like l1 = new Like(null, p1, u1);
        Like l2 = new Like(null, p1, u2);
        Like l3 = new Like(null, p2, u1);
        Like l4 = new Like(null, p2, u3);
        Like l5 = new Like(null, p2, u2);

        userRepository.saveAll(Arrays.asList(
                u1, u2, u3, u4, u5, u6, u7, u8, u9, u10,
                u11, u12, u13, u14, u15, u16, u17, u18, u19, u20,
                u21, u22, u23, u24, u25, u26, u27, u28, u29, u30,
                u31, u32, u33
        ));
        postRepository.saveAll(Arrays.asList(
                p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,
                p11, p12, p13, p14, p15, p16, p17, p18, p19, p20,
                p21, p22, p23, p24, p25, p26, p27, p28, p29, p30,
                p31, p32, p33, p34, p35, p36, p37, p38, p39, p40,
                p41, p42, p43, p44, p45, p46, p47, p48, p49, p50,
                p51, p52, p53, p54, p55, p56, p57, p58, p59, p60,
                p61, p62, p63, p64, p65, p66, p67, p68, p69, p70,
                p71, p72, p73, p74, p75, p76, p77, p78, p79, p80,
                p81, p82, p83, p84, p85, p86, p87, p88, p89, p90,
                p91, p92, p93, p94, p95, p96, p97, p98, p99, p100,
                p101, p102, p103, p104, p105, p106, p107, p108, p109, p110,
                p111, p112, p113, p114, p115, p116, p117, p118, p119, p120,
                p121, p122, p123, p124, p125, p126, p127, p128, p129, p130,
                p131, p132, p133
        ));
        likeRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
    }
}
