/* description: Parses end executes mathematical expressions. */

/* lexical grammar */
%lex

%{
  var variables_musicales = { DO : 'DO', RE : 'RE', MI : 'MI', FA : 'FA', SOL : 'SOL', LA : 'LA', SI : 'SI', R : 'R', B : 'B', N : 'N', C : 'C', SC : 'SC' };
%}

%%

\s+                     /* skip whitespace */
[0-9]+                  return 'TONO'
"-"                     return '-' 
";"                     return ';'
"b"                     return 'b'
"#"                     return '#'
[A-Z]+                  return variables_musicales[yytext]
//<<EOF>> return 'EOF'
. return 'INVALID'

/lex


/* operator associations and precedence */
%left '-'
%left ';'
%start P

%% /* language grammar */
P         :   CANCION
                     {
                         console.log($$);
                         return [ "<ul>\n<li> Música<p> "+ $$ + "\n </ul>"];
                     }
          ;

CANCION   :   NOTA ";"
          |   NOTA ";" CANCION
                 { $$ += $3; }
          ;
        
NOTA      :   NOMBRE "-" SILENCIO "-" TONO
                 { $$ = "{" + $1 + ", " + $3 + ", " + $5 + "} "; }

          |   SILENCIO
                 { $$ = "{" + $1 + "} "; }
          ;
          
NOMBRE    :   DO
                 { $$ = 0; }
          |   DO '#'
                 { $$ = 1; }
          |   RE 'b'
                 { $$ = 2; }
          |   RE
                 { $$ = 3; }
          |   RE '#'
                 { $$ = 4; }
          |   MI 'b'
                 { $$ = 5; }
          |   MI
                 { $$ = 6; }
          |   FA
                 { $$ = 7; }
          |   FA '#'
                 { $$ = 8; }
          |   SOL 'b'
                 { $$ = 9; }
          |   SOL
                 { $$ = 10; }
          |   SOL '#'
                 { $$ = 11; }
          |   LA 'b'
                 { $$ = 12; }
          |   LA
                 { $$ = 13; }
          |   LA '#'
                 { $$ = 14; }
          |   SI 'b'
                 { $$ = 15; }
          |   SI
                 { $$ = 16; }
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