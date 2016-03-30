package com.bugsense.trace;

import android.content.Context;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;

public class CryptoHttpClient extends DefaultHttpClient
{
  public static final int ANALYTICS = 0;
  private static final String BASE64KEYANALYTICS = "AAAAAQAAABROxuBB/aUFmT3yact6TK5IOds4eQAABIABAAVteWtleQAAATltDpSyAAAAAAAFWC41MDkAAAMgMIIDHDCCAoWgAwIBAgIJAJMoXqN3LTQpMA0GCSqGSIb3DQEBBQUAMIGmMQswCQYDVQQGEwJVUzELMAkGA1UECAwCREUxETAPBgNVBAcMCERlbGF3YXJlMRYwFAYDVQQKDA1CdWdTZW5zZSBJbmMuMR4wHAYDVQQLDBVDZXJ0aWZpY2F0ZSBBdXRob3JpdHkxHjAcBgNVBAMMFUNlcnRpZmljYXRlIEF1dGhvcml0eTEfMB0GCSqGSIb3DQEJARYQb3BzQGJ1Z3NlbnNlLmNvbTAeFw0xMjA4MjcxNTU4MzVaFw0yMjA4MjUxNTU4MzVaMIGmMQswCQYDVQQGEwJVUzELMAkGA1UECAwCREUxETAPBgNVBAcMCERlbGF3YXJlMRYwFAYDVQQKDA1CdWdTZW5zZSBJbmMuMR4wHAYDVQQLDBVDZXJ0aWZpY2F0ZSBBdXRob3JpdHkxHjAcBgNVBAMMFUNlcnRpZmljYXRlIEF1dGhvcml0eTEfMB0GCSqGSIb3DQEJARYQb3BzQGJ1Z3NlbnNlLmNvbTCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEAtKnp4mKe+5iOpV7BfiPWz/4KWjwLrQG2V89fmS8iJ2o63yjMgBYyRKgoHEp9h4TIwzmmTrZw63Q5wE0DnUQwMB+oNCAWCxzZxfGd9dz/omxFvbL1SiqTg7jNjjkzR6JVN3EmjY+CU742DTTKsa6eFTyaRfcexCj1gW+HHSef5q0CAwEAAaNQME4wHQYDVR0OBBYEFL6lHUJktOncX8C7umbgoombEmkGMB8GA1UdIwQYMBaAFL6lHUJktOncX8C7umbgoombEmkGMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEABKsEXB7Rn8nz5qgNhOHZtt/bTiA31PyT73sEVQftEOIwOY1CEVC8I6iGn/tBhyeIDpQOVUpTftlaX3UtBeSPzzfnv7a+eZFIdcsgCtSZJ3DpZiY0Fkk4MgbueQEMed1wxl7mfgWGC/fgyZNpw33VuTpSYIFx1FGw9JnBxWJCW9oAKo+JAbCJoSyLOAs15lw1qAknCtI=";
  private static final String BASE64KEYERRORS = "AAAAAQAAABTqE8O13A7h+0EkKxWZwl/MrC5GHgAABYgBAAVteWtleQAAATmbH+bhAAAAAAAFWC41MDkAAAReMIIEWjCCA0KgAwIBAgILBAAAAAABL07hQUMwDQYJKoZIhvcNAQEFBQAwVzELMAkGA1UEBhMCQkUxGTAXBgNVBAoTEEdsb2JhbFNpZ24gbnYtc2ExEDAOBgNVBAsTB1Jvb3QgQ0ExGzAZBgNVBAMTEkdsb2JhbFNpZ24gUm9vdCBDQTAeFw0xMTA0MTMxMDAwMDBaFw0yMjA0MTMxMDAwMDBaMFcxCzAJBgNVBAYTAkJFMRkwFwYDVQQKExBHbG9iYWxTaWduIG52LXNhMS0wKwYDVQQDEyRHbG9iYWxTaWduIERvbWFpbiBWYWxpZGF0aW9uIENBIC0gRzIwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCxo83A3zNAJuveWteUZtQBY8wzRIng4rjCRw2PrWmGHKhzQgvxcvstrLURcoMi9lbnLsVncZ0AHDK84+0uCEWp5vrdyIyDBcFvS9AmSgv2G0XATX6TvA0nhO0wo+nGJibdLR/Yi8POGdBb/Aif5NjiNeSgaKb2DaN0YEKyl4IkjkGk8i5eto6nbtlsfw07JDVq0KtbaveXAgA/UaanbnPKdw12fJu2MBoanPcfKHsOi0cf538FjMbJyLvP6dx6QS6hhtrUObLiE0CmqDr6D1MeT+xumAkbypp3s1WFhekuFrWdXlTxSnpsObpuFwY0s7JC4ffznJoLEUTeaniOsRNPAgMBAAGjggElMIIBITAOBgNVHQ8BAf8EBAMCAQYwEgYDVR0TAQH/BAgwBgEB/wIBADAdBgNVHQ4EFgQUlq36sFu5g2QqdsIcimnaQtz+/SgwRwYDVR0gBEAwPjA8BgRVHSAAMDQwMgYIKwYBBQUHAgEWJmh0dHBzOi8vd3d3Lmdsb2JhbHNpZ24uY29tL3JlcG9zaXRvcnkvMDMGA1UdHwQsMCowKKAmoCSGImh0dHA6Ly9jcmwuZ2xvYmFsc2lnbi5uZXQvcm9vdC5jcmwwPQYIKwYBBQUHAQEEMTAvMC0GCCsGAQUFBzABhiFodHRwOi8vb2NzcC5nbG9iYWxzaWduLmNvbS9yb290cjEwHwYDVR0jBBgwFoAUYHtmGkUNl8qJUC99BM00qP/8/UswDQYJKoZIhvcNAQEFBQADggEBADrn/K6vBUOAJ3VBX6jwKI8fj4N+sri6rnUxJ4il5blOBEPSregTAKPbGQEwnmw8Un9c3qtnw4QEVFGZnmMvvdW3wNXaAw5J0+Gzkk/fkk59riJqzti8/Hyua7aK6kVikBHTC3GnXgYi/0046rk6bs1nGgJ/S/O/DnlvvtUpMllZHZYIm3CP9x5cRntO0J20U8gSAhsNuzLrWVO5PhtWjRXI8UI/d/4f5W2eZh+r2rKDV7QMItKGvNoy18DtcIV8k6rwl9w5EdLYieuNkKO2UCXLbNmmw2/7iFS45JJwh855O/DeNr8DBAA9+e+eqWek9IY+I5e4KnHi7f5piGe/JlwA1dUF+2pp1as1qpadDzN/FNFE+2Q=";
  public static final int ERRORS = 1;
  int KEY = 0;
  final Context context;

  public CryptoHttpClient(Context paramContext, int paramInt)
  {
    this.context = paramContext;
    this.KEY = paramInt;
  }

  // ERROR //
  private org.apache.http.conn.ssl.SSLSocketFactory newSslSocketFactory()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/bugsense/trace/CryptoHttpClient:KEY	I
    //   4: ifne +67 -> 71
    //   7: ldc 11
    //   9: astore_1
    //   10: aload_1
    //   11: invokestatic 38	biz/source_code/base64Coder/Base64Coder:decode	(Ljava/lang/String;)[B
    //   14: astore_2
    //   15: ldc 40
    //   17: invokestatic 46	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   20: astore 5
    //   22: new 48	java/io/ByteArrayInputStream
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 51	java/io/ByteArrayInputStream:<init>	([B)V
    //   30: astore 6
    //   32: aload 5
    //   34: aload 6
    //   36: ldc 53
    //   38: invokevirtual 59	java/lang/String:toCharArray	()[C
    //   41: invokevirtual 63	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   44: aload 6
    //   46: invokevirtual 68	java/io/InputStream:close	()V
    //   49: new 70	org/apache/http/conn/ssl/SSLSocketFactory
    //   52: dup
    //   53: aload 5
    //   55: invokespecial 73	org/apache/http/conn/ssl/SSLSocketFactory:<init>	(Ljava/security/KeyStore;)V
    //   58: astore 8
    //   60: aload 8
    //   62: getstatic 77	org/apache/http/conn/ssl/SSLSocketFactory:ALLOW_ALL_HOSTNAME_VERIFIER	Lorg/apache/http/conn/ssl/X509HostnameVerifier;
    //   65: invokevirtual 81	org/apache/http/conn/ssl/SSLSocketFactory:setHostnameVerifier	(Lorg/apache/http/conn/ssl/X509HostnameVerifier;)V
    //   68: aload 8
    //   70: areturn
    //   71: ldc 14
    //   73: astore_1
    //   74: goto -64 -> 10
    //   77: astore 7
    //   79: aload 6
    //   81: invokevirtual 68	java/io/InputStream:close	()V
    //   84: aload 7
    //   86: athrow
    //   87: astore_3
    //   88: getstatic 86	com/bugsense/trace/G:TAG	Ljava/lang/String;
    //   91: new 88	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   98: ldc 91
    //   100: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_3
    //   104: invokevirtual 99	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   107: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 108	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   116: pop
    //   117: getstatic 114	com/bugsense/trace/BugSenseHandler:I_WANT_TO_DEBUG	Z
    //   120: ifeq +7 -> 127
    //   123: aload_3
    //   124: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   127: new 119	java/lang/AssertionError
    //   130: dup
    //   131: aload_3
    //   132: invokespecial 122	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   135: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   32	44	77	finally
    //   15	32	87	java/lang/Exception
    //   44	68	87	java/lang/Exception
    //   79	87	87	java/lang/Exception
  }

  protected ClientConnectionManager createClientConnectionManager()
  {
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("https", newSslSocketFactory(), 443));
    return new SingleClientConnManager(getParams(), localSchemeRegistry);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.bugsense.trace.CryptoHttpClient
 * JD-Core Version:    0.6.2
 */