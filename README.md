# BusinessDay
* Tomcatをインストールする
    * 以下のサイトから任意のフォルダにTomcatをインストールする
         * http://tomcat.apache.org/
* Eclipse marketplaceからTomcat pluginをダウンロードする
    * Eclipseメニュー「Eclipse -> Help -> Eclipse market place  -> serch」から"Tomcat plugin"を検索する
    * 検索結果の「Eclipse Tomcat Plugin」をインストールする
    * 以下のエラーが発生した場合は当手順を飛ばし次の手順へ進む
        * http://tomcatplugin.sf.net/update/content.xml のリポジトリーを読み取ることが出来ません。
* Update siteからTomcat pluginをダウンロードする
    * Update siteの「Download update site archive (1.5 MB)」のリンクからzipファイルをダウンロードする
        * https://sourceforge.net/projects/tomcatplugin/files/updatesite/






----------------------------------------------------------------------------

* install the Tomcat
    * http://tomcat.apache.org/
* install the Tomcat plugin from Eclipse marketplace
    * Eclipse -> Help -> Eclipse market place  -> serch the "Tomcat plugin"
* set up the Tomcat on Eclipse
    * Eclipse -> perspective -> Tomcat
      *  select the Tomcat version
      *  fill in the Tomcat home
* set up the log4j library on Eclipse
    * select the BusinessDay prj on Package Explorer -> Properties -> library -> Add External JARS
      *  select log4j

