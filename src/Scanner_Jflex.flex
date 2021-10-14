%%
%public
%class Scanner_phase1
%unicode
%line
%column
%type String
%{
StringBuilder answer=new StringBuilder();
private void handle_key_words(String s){
    answer.append(s+"\n");
}
%}
all_type_of_comment={comment_type_one}|{comment_type_two}
comment_type_one="/*" [^*] ~"*/"
comment_type_two="//".*
white_space=\r|\n|\r\n|\t|\f
string=\"[[^\n\r\"\\]|\\t|\\r|\\n|\'|\\|\\\"]+\"
double=\d+\.\d*[eE][-+]?\d+
integer=\d+
int16 = [0][xX][0-9a-fA-F]+

%%
/*handle keywords*/
__func__|__line__| bool| break| btoi| class| continue| define| double| dtoi| else| for|
if| import| int| itob| itod| new| NewArray| null| Print| private| public| ReadInteger|
ReadLine|return| string| this| void| while      {handle_key_words(yytext());}
/*handle string*/
{string}                  {answer.append("T_STRINGLITERAL "+yytext()+"\n");}
/*handle boolean*/
true|false                {answer.append("T_BOOLEANLITERAL "+yytext()+"\n");}
/*handle comments*/
{all_type_of_comment}     {}
/*handle whitespace*/
{white_space}             {}
<<<<<<< HEAD:src/Scanner_Jflex.jflex
/*handel error*/
[^]                        {answer=new StringBuilder();answer.append("error");}
=======
/*handle error*/
[^]                        {answer=new StringBuilder();answer.append("error");}
/*handle operators*/
"&&" | "||" | "!" | "!=" | "<" | "<=" | ">" | ">=" | "%" | "/" | "/=" | "*" | "*=" | "=" | "==" |
"+" | "+=" | "++" | "- " | "-=" | "--" | "." | "," | ";" | "(" | ")" | "{" | "}" | "[" | "]" {handle_key_words(yytext());}
/*handle string*/
{integer} | {int16}                  {answer.append("T_INTLITERAL "+yytext()+"\n");}
/*handle string*/
{double}                  {answer.append("T_DOUBLELITERAL "+yytext()+"\n");}
/*handle identifiers*/
[a-zA-Z][a-zA-Z0-9_]* {answer.append("T_ID "+yytext()+"\n");}
>>>>>>> 7f45c00ad56e926be1b85986155b7ec4faa56527:src/Scanner_Jflex.flex
