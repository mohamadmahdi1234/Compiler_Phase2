%%
%public
%class Lexer
%unicode
%line
%column
%{
StringBuilder answer=new StringBuilder();
%}
all_type_of_comment={comment_type_one}|{comment_type_two}
comment_type_one="/*" [^*] ~"*/"
comment_type_two="//".*
white_space=\r|\n|\r\n|\t|\f
%%
{all_type_of_comment}     {}
{white_space}             {}
[^]                        {answer=new StringBuilder();answer.append("error");}

