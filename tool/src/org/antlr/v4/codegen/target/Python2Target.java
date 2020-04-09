package org.antlr.v4.codegen.target;
import org.antlr.v4.codegen.CodeGenerator;
import org.antlr.v4.codegen.Target;
import org.antlr.v4.tool.ast.GrammarAST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.StringRenderer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/** 
 * @author Eric Vergnaud
 */
public class Python2Target extends Target {
  public static String[] python2Keywords={"abs","all","any","apply","as","bin","bool","buffer","bytearray","callable","chr","classmethod","coerce","compile","complex","del","delattr","dict","dir","divmod","enumerate","eval","execfile","file","filter","float","format","frozenset","getattr","globals","hasattr","hash","help","hex","id","input","int","intern","isinstance","issubclass","iter","len","list","locals","map","max","min","next","memoryview","object","oct","open","ord","pow","print","property","range","raw_input","reduce","reload","repr","return","reversed","round","set","setattr","slice","sorted","staticmethod","str","sum","super","tuple","type","unichr","unicode","vars","with","xrange","zip","__import__","True","False","None"};
  /** 
 * Avoid grammar symbols in this set to prevent conflicts in gen'd code. 
 */
  public Set<String> badWords=new HashSet<String>();
  public Python2Target(  CodeGenerator gen){
    super(gen,"Python2");
  }
  @Override public boolean visibleGrammarSymbolCausesIssueInGeneratedCode(  GrammarAST idNode){
    return getBadWords().contains(idNode.getText());
  }
  @Override public STGroup loadTemplates(){
    STGroup result=super.loadTemplates();
    result.registerRenderer(String.class,new PythonStringRenderer(),true);
    return result;
  }
public static class PythonStringRenderer extends StringRenderer {
    @Override public String toString(    Object o,    String formatString,    Locale locale){
      return super.toString(o,formatString,locale);
    }
    public PythonStringRenderer(){
    }
  }
  @Override public boolean wantsBaseListener(){
    return false;
  }
  @Override public boolean wantsBaseVisitor(){
    return false;
  }
  @Override public boolean supportsOverloadedMethods(){
    return false;
  }
  @Override public String getVersion(){
    return "4.5.2.1";
  }
  public Set<String> getBadWords(){
    if (badWords.isEmpty()) {
      addBadWords();
    }
    return badWords;
  }
  public void addBadWords(){
    badWords.addAll(Arrays.asList(python2Keywords));
    badWords.add("rule");
    badWords.add("parserRule");
  }
  public Python2Target(){
  }
}
