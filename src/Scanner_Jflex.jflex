%%
%public
%class Scanner
%unicode
%line
%column
%{
StringBuilder answer=new StringBuilder();
private void handle_key_words(String s){
    answer.append(s);
}
%}
all_type_of_comment={comment_type_one}|{comment_type_two}
comment_type_one="/*" [^*] ~"*/"
comment_type_two="//".*
white_space=\r|\n|\r\n|\t|\f
string=\"[[^\n\r\"\\]|\\t|\\r|\\n|\'|\\|\\\"]+\"

%%
/*handel keywords*/
__func__|__line__| bool| break| btoi| class| continue| define| double| dtoi| else| for|
if| import| int| itob| itod| new| NewArray| null| Print| private| public| ReadInteger|
ReadLine|return| string| this| void| while      {handle_key_words(yytext());}
/*handel string*/
{string}                  {answer.append("T_STRINGLITERAL "+yytext());}
/*handel comments*/
{all_type_of_comment}     {}
/*handel whitespace*/
{white_space}             {}
/*handel error*/
[^]                        {answer=new StringBuilder();answer.append("error");}

