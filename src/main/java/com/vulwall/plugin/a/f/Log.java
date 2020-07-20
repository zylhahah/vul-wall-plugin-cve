package com.vulwall.plugin.a.f;


import org.codehaus.plexus.logging.*;

public class Log
    implements org.apache.maven.plugin.logging.Log, Logger
{

    @Override
    public boolean isDebugEnabled()
    {
        return false;
    }


    @Override
    public void debug( CharSequence content )
    {
        // nop
    }


    @Override
    public void debug( CharSequence content, Throwable error )
    {

    }

    @Override
    public void debug( Throwable error )
    {
        // nop
    }

    @Override
    public boolean isInfoEnabled()
    {
        return false;
    }


    @Override
    public void info( CharSequence content )
    {
        // nop
    }


    @Override
    public void info( CharSequence content, Throwable error )
    {
        // nop
    }


    @Override
    public void info( Throwable error )
    {
        // nop
    }

    @Override
    public boolean isWarnEnabled()
    {
        // nop
        return false;
    }

    @Override
    public void warn( CharSequence content )
    {
        // nop
    }

    @Override
    public void warn( CharSequence content, Throwable error )
    {
        // nop
    }


    @Override
    public void warn( Throwable error )
    {
        // nop
    }


    @Override
    public boolean isErrorEnabled()
    {
        return false;
    }

    @Override
    public void error( CharSequence content )
    {
        // nop
    }


    @Override
    public void error( CharSequence content, Throwable error )
    {
        // nop
    }


    @Override
    public void error( Throwable error )
    {
        // nop
    }

    @Override
    public void debug( String message )
    {
        // nop
    }

    @Override
    public void debug( String message, Throwable throwable )
    {
        // nop
    }


    @Override
    public void info( String message )
    {
        // nop
    }

    @Override
    public void info( String message, Throwable throwable )
    {
        // nop
    }


    @Override
    public void warn( String message )
    {
        // nop
    }


    @Override
    public void warn( String message, Throwable throwable )
    {
        // nop
    }

    @Override
    public void error( String message )
    {
        // nop
    }


    @Override
    public void error( String message, Throwable throwable )
    {
        // nop
    }


    @Override
    public void fatalError( String message )
    {
        // nop
    }


    @Override
    public void fatalError( String message, Throwable throwable )
    {
        // nop
    }


    @Override
    public boolean isFatalErrorEnabled()
    {
        return false;
    }

    @Override
    public Logger getChildLogger( String name )
    {
        return null;
    }


    @Override
    public int getThreshold()
    {
        return 0;
    }


    @Override
    public void setThreshold( int threshold )
    {
        // nop
    }


    @Override
    public String getName()
    {
        return null;
    }
}
