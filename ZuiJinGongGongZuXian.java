{\rtf1\ansi\deff0\nouicompat{\fonttbl{\f0\fnil\fcharset134 \'cb\'ce\'cc\'e5;}}
{\*\generator Riched20 10.0.18362}\viewkind4\uc1 
\pard\sa200\sl276\slmult1\f0\fs22\lang2052 import java.util.*;\par
\par
public class LCA \{\par
    public int getLCA(int a, int b) \{\par
        while (a!=b)\{\par
            if(a>b)\par
                a>>=1;\par
            else\par
                b>>=1;\par
        \}\par
        return a;\par
    \}\par
\}\par
}
 