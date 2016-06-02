/*
Sri Mounika Puvvada
Advanced Programming Languages
gcd.c
project 4
*/
#include <stdio.h>
int main(int argc,char *argv[])
{
  	int a,b,m;
	if(argc>0){
  		a=atoi(argv[1]);
  		b=atoi(argv[2]);
	}		
	m=gcd(a,b);
  	printf("%d",m);
   return 0;
}
int gcd ( int a, int b )
{
  int c;
  while ( a != 0 ) {
     c = a;
     a = b%a;
     b = c;
  }
  return b;
}
