create database ftt;
Use ftt;


create table Professor(
	ID int auto_increment primary key,
    NomeProfessor nvarchar(50),
    CPFProfessor nvarchar(14),
    DataDeNascimentoProfessor datetime,
	Registro nvarchar(13)
);
create table Turma(
	ID int auto_increment,
    Descricao nvarchar(20),
    constraint pk_turma primary key(ID),
    ProfessorID int not null,
    constraint fk_turma_professor foreign key (ProfessorID) references Professor(ID)
);
create table Aluno(
	ID int auto_increment,
    NomeAluno nvarchar(50),
    CPFAluno nvarchar(14),
    DataNascimentoAluno datetime,
    TurmaID int not null,
    constraint pk_aluno primary key(ID),
    constraint fk_aluno_turma foreign key (TurmaID) references Turma(ID)
);


insert into Professor(NomeProfessor, CPFProfessor, DataDeNascimentoProfessor, Registro) value ("Allana Nicole Melo", "296.067.808-72", "1983-06-06", 1254789645231);
insert into Professor(NomeProfessor, CPFProfessor, DataDeNascimentoProfessor, Registro) value ("Alícia Marli Fogaça", "661.371.368-68", "1983-11-24", 1285492045231);
insert into Professor(NomeProfessor, CPFProfessor, DataDeNascimentoProfessor, Registro) value ("Gabrielly Kamilly Moura", "757.017.458-56", "1983-05-26", 2512587515231);
insert into Professor(NomeProfessor, CPFProfessor, DataDeNascimentoProfessor, Registro) value ("Fernanda Louise da Cruz", "816.494.748-22", "1991-10-08", 7852156214525);
insert into Professor(NomeProfessor, CPFProfessor, DataDeNascimentoProfessor, Registro) value ("Alana Marcela Teixeira", "664.690.458-80", "1987-12-13", 5198523220523);





insert into Turma(Descricao, ProfessorID) values ("Fundamental 1", 1);
insert into Turma(Descricao, ProfessorID) values ("Fundamental 2", 2);
insert into Turma(Descricao, ProfessorID) values ("Fundamental 3", 3);
insert into Turma(Descricao, ProfessorID) values ("Fundamental 4", 4);

insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Pedro Henrique Monteiro", "792.256.828-24", "2013-10-12", 1);
insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Giovanni Iago Assis", "850.597.068-34", "2013-01-02", 1);
insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Anthony Mário Moura", "567.487.848-08", "2013-09-08", 1);
insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Thomas Pedro Henrique Porto", "412.415.648-09", "2013-05-20", 1);
insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Isabelly Heloisa Isabella da Conceição", "152.015.468-20", "2013-03-07", 1);
insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Ayla Valentina Rezende", "766.141.738-39", "2013-05-12", 1);
insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Bárbara Eduarda Giovana Melo", "024.127.038-33", "2013-04-18", 1);
insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Rafael Heitor Oliver Carvalho", "147.682.498-33", "2013-02-09", 1);


insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Filipe Anderson Jorge Nunes", "933.565.828-60", "2013-05-03", 2);
insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Murilo Samuel da Costa", "253.126.848-05", "2013-08-05", 2);
insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Rafael Ricardo Almada", "091.690.418-06", "2013-10-20", 2);
insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Carla Clara Souza", "210.599.348-68", "2013-10-30", 2);
insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Carolina Cláudia Sara Barbosa", "835.734.348-19", "2013-11-15", 2);
insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Sandra Catarina Márcia Castro", "356.983.618-51", "2013-07-27", 2);


insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Isabel Maria Moraes", "045.468.708-76", "2013-04-12", 3);
insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Agatha Clarice da Cunha", "391.585.328-38", "2013-02-07", 3);
insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Enzo Renato Bernardo Vieira", "370.408.358-51", "2013-06-02", 3);
insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Levi Igor Assunção", "949.020.518-42", "2013-08-03", 3);


insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Felipe Mário Duarte", "930.335.618-70", "2013-10-08", 4);
insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Henry Marcos Santos", "723.571.008-00", "2013-08-12", 4);
insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Cláudia Gabrielly Novaes", "761.721.738-20", "2013-02-12", 4);
insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID) value ("Laís Betina Márcia Bernardes", "962.205.138-35", "2013-12-12", 4);

Delimiter $$
create procedure InsertAluno (NomeAluno nvarchar(50), CPF nvarchar(14), DataDeNascimento datetime, NomeDaTurma nvarchar(20))
Begin
	Declare IDTurma int;
    Declare IDAluno int;
    
    select IDTurma = ID from Turma where Descricao = NomeDaTurma;
	Select IDAluno = ID from Aluno where CPFAluno = CPF;
    
    if (IDTurma is not null and IDAluno is null)
    then
		insert into Aluno(NomeAluno, CPFAluno, DataNascimentoAluno, TurmaID)  value (NomeAluno, CPF, DataDeNascimento, IDTurma);
    end if;
        
end $$

Delimiter $$
create procedure InsertProfessor (NomeProfessor nvarchar(50), CPFProfessor nvarchar(14), DataDeNascimento datetime, RegistroProfessor nvarchar(13))
Begin

	
    Declare IDProfessor int;
    
    select IDProfessor = ID from Professor where Registro = Registro;
   
    
    if (IDProfessor is null)
    then
		insert into Professor(NomeProfessor, CPFProfessor, DataDeNascimentoProfessor, Registro) value (NomeProfessor, CPFProfessor, DataDeNascimento, Registro);
    end if;
        
end $$

Delimiter $$
create procedure InsertTurma (NomeDaTurma nvarchar(20), RegistroDoProfessor nvarchar(13))
Begin
	Declare IDTurma int;
    
    Declare IDProfessor int;
    select IDTurma = ID from Turma where Descricao = NomeDaTurma;
    select IDProfessor = ID from Professor where Registro = Registro;
   
    
    if (IDTurma is null and IDProfessor is not null)
    then
		insert into Turma(Descricao, ProfessorID) values (NomeDaTurma, RegistroDoProfessor);
    end if;
        
end $$

Delimiter $$
create procedure UpdateAluno (NomeDoAluno nvarchar(50), CPF nvarchar(14), DataDeNascimento datetime, NomeDaTurma nvarchar(20))
Begin
	Declare IDTurma int;
    Declare IDAluno int;

    select IDTurma = ID from Turma where Descricao = NomeDaTurma;
	select IDAluno = ID from Aluno where CPFAluno = CPF;
    
    if (IDTurma is not null and IDAluno is not null)
    then
		Update Aluno
        set NomeAluno = NomeDoAluno, DataNascimentoAluno = DataDeNascimento, TurmaID = IDTurma
        where ID = IDAluno;
		
    end if;
        
end $$

Delimiter $$
create procedure UpdateProfessor (NomeDOProfessor nvarchar(50), CPFDOProfessor nvarchar(14), DataDeNascimento datetime, RegistroProfessor nvarchar(13))
Begin
    Declare IDProfessor int;

    select IDProfessor = ID from Professor where Registro = RegistroProfessor;
    
    if (IDProfessor is not null)
    then
   
		Update Professor
        set NomeProfessor = NomeDOProfessor, CPFProfessor = CPFDOProfessor, DataDeNascimentoProfessor = DataDeNascimento
        where ID = IDProfessor;
		
    end if;
        
end $$

Delimiter $$
create procedure UpdateTurma(Descricao nvarchar(20), NovoProfessorID int)
Begin
	Declare IDTurma int;
     select IDTurma = ID from Turma where Descricao = NomeDaTurma;
     
     if(IDTurma is not null)
     Then
		update Turma
        set ProfessorID = NovoProfessorID
        where ID = IDTurma;
     end if;
End $$

Delimiter $$
create procedure DeleteAluno(IDAluno int)
Begin
	delete from Aluno 
    where ID = IDAluno;
    
End $$

Delimiter $$
create procedure DeleteTurma(IDTurma int)
Begin
	declare QuantidadeAlunos int;
    
    select QuantidadeAlunos = Count(ID) from Aluno where TurmaID = IDTurma;
    
    if(QuantidadeAlunos = 0)
    Then
		delete from Turma 
		where ID = IDTurma;
	End IF;
    
End $$

Delimiter $$
create procedure DeleteProfessor (IDProfessor int)
Begin
	declare QuantidadeTurmas int;
    
    select QuantidadeTurmas = Count(ID) from Turma where ProfessorID = IDProfessor;
    if(QuantidadeTurmas = 0)
    then
		delete from Professor 
		where ID = IDProfessor;
	End if;
    
End $$








