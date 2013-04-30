/* description: Parses end executes mathematical expressions. */

/* lexical grammar */
%lex
%%
/*%{
  var notas_musicales = { DO : 'DO', RE : 'RE', MI : 'MI', FA : 'FA', SOL : 'SOL', LA : 'LA', SI : 'SI' };
  var silencios = { R : 'R', B : 'B', N : 'N', C : 'C', SC : 'SC' };
%}*/

\s+                   /* skip whitespace */
[0-9]+                return 'TONO'
"-"                   return '-'
";"                   return ';'
"DO"                  return 'DO'
"RE"                  return 'RE' 
"MI"                  return 'MI'
"FA"                  return 'FA'
"SOL"                 return 'SOL'
"LA"                  return 'LA'
"SI"                  return 'SI'
"R"                   return 'R'
"B"                   return 'B'
"N"                   return 'N'
"C"                   return 'C'
"SC"                  return 'SC'
//"#"                   return '#'
//[a-zA-Z][a-zA-Z]*     return notas_musicales[yytext]
//[a-zA-Z][a-zA-Z]*     return silencios[yytext]
//<<EOF>>               return 'EOF'
.                     return 'INVALID'

/lex
	

/* operator associations and precedence */
%left '-' 
%left ';'
%start P

%% /* language grammar */
P         :   CANCION
                     {
                         return [ "<ul>\n<li> Música<p> "+ $$ + "\n </ul>"];
                     }          
          ;

CANCION   :   NOTA ";"
          |   NOTA ";" CANCION
              { $$ += $3; }
          ;
        
NOTA      :   NOMBRE "-" SILENCIO "-" TONO
                 { $$ = "{" + $1 + ", " + $3 + ", " + $5 + "} "; }
          //|   NOMBRE "#" "-" SILENCIO "-" TONO          En este caso deberiamos de sumar un 1 al valor que nos de NOMBRE,
          //                                              hay que comprobar que es una nota con sostenido         
          |   SILENCIO
                 { $$ = "{" + $1 + "} "; }
          ;
          
NOMBRE    :   DO
                 { $$ = 0; }
          |   RE
                 { $$ = 2; }              
          |   MI
                 { $$ = 4; }
          |   FA
                 { $$ = 5; }
          |   SOL
                 { $$ = 7; }
          |   LA
                 { $$ = 9; }
          |   SI
                 { $$ = 11; }
          ;
          
SILENCIO  :   R
                 { $$ = 0; }
          |   B
                 { $$ = 1; }
          |   N
                 { $$ = 2; }
          |   C
                 { $$ = 3; }
          |   SC
                 { $$ = 4; }
          ;
          