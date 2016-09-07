#include <stdio.h>
#include <argp.h>

#define __DEBUG__

#ifdef __DEBUG__
	#define LOG(A)  printf A
#else
	#define LOG(A)
#endif
// http://crasseux.com/books/ctutorial/argp-description.html#argp%20description
// ./argex --verbose -a 123 --bravo=456 Foo Joo

// 变量名称是argp规定使用，不能改动
const char *argp_program_version = "argex 2.0";
const char *argp_program_bug_address = "<yananback@gmail.com>";

/* This structure is used by main to communicate with parse_opt. */
struct arguments
{
  char 	*args[2];          		/* ARG1 and ARG2 */
  int 	verbose;              	/* The -v flag */	// 也就是详细模式
  char 	*outfile;            	/* Argument for -o */
  char 	*string1, *string2;  	/* Arguments for -a and -b */
};

/*
   OPTIONS.  Field 1 in ARGP.
   Order of fields: {NAME, KEY, ARG, FLAGS, DOC}.
*/
static struct argp_option options[] =
{
	{"verbose", 'v', 0, 0, "Produce verbose output"},
  	{"alpha",   'a', "STRING1", 0,
   		"Do something with STRING1 related to the letter A"},
  	{"bravo",   'b', "STRING2", 0,
   		"Do something with STRING2 related to the letter B"},
  	{"output",  'o', "OUTFILE", 0,
   		"Output to OUTFILE instead of to standard output"},
  	{0}
};


/*
   PARSER. Field 2 in ARGP.
   Order of parameters: KEY, ARG, STATE.
*/
static error_t parse_opt (int key, char *arg, struct argp_state *state)
{
  	struct arguments *arguments = state->input;
	//int i;
	//for(i=0; i<state->argc; i++){
	//	LOG(("state->argv[%d]=%s\n",i,state->argv[i]));
	//}

	LOG(("-----------------------------------\n"));
	LOG(("key=%c\targ:%s\targ_num:%d\tstate->next=%d\n",key,arg,\
				state->arg_num,state->next));
  	switch (key){
    	case 'v':
      		arguments->verbose = 1;		// 准备输出详细的内容
      		break;
    	case 'a':
    	  	arguments->string1 = arg;
    	  	break;
    	case 'b':
    	  	arguments->string2 = arg;
    	  	break;
    	case 'o':
    	  	arguments->outfile = arg;
    	  	break;
    	case ARGP_KEY_ARG:		// 这里是无标识的输入参数，保存在state->args中
			LOG(("ARGP_KEY_ARG,key=%c\n",key));
    	  	if (state->arg_num >= 2)
			{
				argp_usage(state);
			}
    	  	arguments->args[state->arg_num] = arg;
    	  	break;
    	case ARGP_KEY_END:		// 这里和ARGP_KEY_ARG配合，使无标识输入只能是两个
			LOG(("ARGP_KEY_END,key=%c\n",key));
    	  	if (state->arg_num < 2){
		  		argp_usage (state);
			}
    	  	break;
		case ARGP_KEY_NO_ARGS:
			LOG(("ARGP_KEY_NO_ARGS\n"));
			argp_state_help(state, stdout, ARGP_HELP_STD_HELP);
    	default:
    	  	return ARGP_ERR_UNKNOWN;
    	}
  	return 0;	// success
}

/*
 * ARGS_DOC. Field 3 in ARGP.
 * A description of the non-option command-line arguments
 * that we accept.
 * 就是现实在usage后面的，如下：
 * Usage: argex [option...] args_doc
 */
static char args_doc[] = "ARG1 ARG2";

/*
 * DOC.  Field 4 in ARGP.
 * Program documentation.
 */
static char doc[] =
	"argex -- A program to demonstrate how to code command-line options \
and arguments.\vFrom the GNU C Tutorial.";

/*
 * The ARGP structure itself.
 * options: 参数选项(为下面的函数做准备)
 * parse_opt: 分析参数，并根据参数标识将后面的内容放入需要的结构体
 * args_doc: 直观的看是参数的说明
 * doc: 这个程序的说明，帮助文档首行显示内容，\v之后的最后显示
 */
static struct argp argp = {options, parse_opt, args_doc, doc};

/*
   The main function.
   Notice how now the only function call needed to process
   all command-line options and arguments nicely
   is argp_parse.
*/
int main (int argc, char **argv)
{
  	struct 	arguments arguments;
  	FILE 	*outstream;

  	char waters[] =
  	  	"a place to stay \
enough to eat \
somewhere old heroes shuffle safely down the street \
where you can speak out loud \
about your doubts and fears \
and what's more no-one ever disappears \
you never hear their standard issue kicking in your door \
you can relax on both sides of the tracks \
and maniacs don't blow holes in bandsmen by remote control \
and everyone has recourse to the law \
and no-one kills the children anymore \
and no-one kills the children anymore \
-- \"the gunners dream\", Roger Waters, 1983\n";

  	/* Set argument defaults */
	// 设置了默认值，如果对应的有参数，argp会再次修改
  	arguments.outfile = NULL;
  	arguments.string1 = "";
  	arguments.string2 = "";
  	arguments.verbose = 0;

  	/* Where the magic happens */
	// The sixth parameter can be useful; in the example below,
	// we use it to pass information from main to our function
	// parse_opt, which does most of the work of initalizing 
	// internal variables (fields in the arguments structure) 
	// based on command-line options and arguments.
	LOG(("before argp_parse\n"));
  	argp_parse (&argp, argc, argv, 0, 0, &arguments);
	LOG(("after argp_parse\n"));

  	/* Where do we send output? */
  	if (arguments.outfile)
  	  outstream = fopen (arguments.outfile, "w");
  	else
  	  outstream = stdout;

  	/* Print argument values */
  	fprintf (outstream, "alpha = %s\nbravo = %s\n\n",
  	     arguments.string1, arguments.string2);
  	fprintf (outstream, "ARG1 = %s\nARG2 = %s\n\n",
  	     arguments.args[0],
  	     arguments.args[1]);

  	/* If in verbose mode, print song stanza */
  	if (arguments.verbose)
		// fprintf(outstream, waters);这样也是对的，但是有警告信息
  	  	fprintf (outstream,"%s", waters);

  	return 0;
}
