
package com.smartgwt.client.docs;

/**
 * <h3>Custom Querying Overview</h3>
 * The Smart GWT server provides a number of ways to let you customize the SQL or Hibernate&#010 query it generates to
 * fetch data from or update your database.  You can provide full &#010 custom queries in either {@link
 * com.smartgwt.client.docs.serverds.OperationBinding#customSQL 'SQL'} or &#010 {@link
 * com.smartgwt.client.docs.serverds.OperationBinding#customHQL 'HQL'}, or you can replace individual parts of the query
 * &#010 ({@link com.smartgwt.client.docs.serverds.OperationBinding#whereClause 'the WHERE clause'}, for example) while
 * letting&#010 Smart GWT generate the rest.  Full custom queries provide complete flexibility, but &#010 they cannot be
 * used for automatic data paging; if you use a full custom query, all of its&#010 data will be returned to the client in
 * one shot.  This may, of course, be perfectly &#010 reasonable, depending on the number of rows involved.  However, if
 * you need automatic &#010 paging support, you should try to implement your customizations by replacing pieces of the&#010
 * query.&#010 <p>&#010 Query customization is done per {@link com.smartgwt.client.data.OperationBinding}, so it is
 * entirely feasible to &#010 provide multiple custom queries for the same {@link
 * com.smartgwt.client.data.OperationBinding#getOperationType 'operation type'} &#010 on a given {@link
 * com.smartgwt.client.data.DataSource}.&#010&#010 <h4>Using criteria and values</h4>&#010 Whether using full custom
 * queries or individual clauses, your code has access to the &#010 criteria values submitted with the operation; if this
 * is an "add" or "update" operation,&#010 it also has access to the new field values sent from the client.&#010 <p>&#010
 * Fields are accessed in your SQL or HQL code using the Velocity template language.  You&#010 can refer to container
 * variables <b>$criteria</b> and <b>$values</b> in your queries or &#010 clause snippets, and Smart GWT will insert the
 * appropriate values.  A simple &#010 {@link com.smartgwt.client.docs.serverds.OperationBinding#whereClause 'whereClause'}
 * example:&#010 <p>&#010 <code>&lt;whereClause&gt;continent = $criteria.continent AND population >
 * $criteria.minPop&lt;/whereClause&gt;</code>&#010 <p>&#010 Please see {@link com.smartgwt.client.docs.VelocitySupport}
 * for full details of accessing Smart GWT &#010 Server context variables using Velocity. &#010 &#010 <h4>Other template
 * variables</h4>&#010 In addition to the Velocity template variables described above, we also provide a number of&#010
 * template variables containing generally-useful values.  Please see&#010 {@link com.smartgwt.client.docs.VelocitySupport}
 * for details.&#010&#010 <h4>Using the default clauses</h4>&#010 You also have access to the {@link
 * com.smartgwt.client..DefaultQueryClause} generated by &#010 Smart GWT.  You can use these in full custom queries to
 * allow a certain part of the query&#010 code to be generated:<p>&#010 <code>SELECT foo, bar FROM $defaultTableClause
 * WHERE baz > $criteria.baz</code>.  &#010 <p>&#010 You can also use them, with care, as a foundation for your own
 * additions:<p>&#010 <code>SELECT $defaultSelectClause, foo, bar FROM $defaultTableClause WHERE ($defaultWhereClause) AND
 * baz > $criteria.baz</code>.&#010 <p>&#010 You can also use them within query snippets in the various subclause
 * properties:<p>&#010 <code>&lt;selectClause&gt;$defaultSelectClause, foo, bar&lt;/selectClause&gt;</code>&#010&#010
 * <h4>Stored procedures</h4>&#010 It is possible to include templated calls to SQL stored procedures in a&#010 {@link
 * com.smartgwt.client.docs.serverds.OperationBinding#customSQL 'customSQL'} clause, for the ultimate in flexibility.  For
 * &#010 example, the deletion of an order might require a number of actions: deletion of the order&#010 record itself,
 * messages sent to other systems (data warehousing, maybe, or a central accounts&#010 system running on a mainframe), an
 * event log written, and so on.  You could write a stored &#010 procedure to do all this, and then invoke it with a
 * customSQL clause:&#010 <pre>&#010    &lt;operationBinding operationType="remove"&gt;&#010        &lt;customSQL&gt;call
 * deleteOrder($criteria.orderNo)&lt;customSQL&gt;&#010    &lt;/operationBinding&gt;&#010 </pre>&#010 <h4>Custom queries
 * are safe</h4>&#010 Custom queries are protected from <a href=http://en.wikipedia.org/wiki/SQL_injection>&#010 SQL
 * injection attacks</a>, because anything coming from the client is quoted and escaped &#010 in accordance with the syntax
 * of the underlying database before use (though see the warning&#010 about using <code>$rawValue</code> in the article on
 * {@link com.smartgwt.client.docs.VelocitySupport}).&#010 So, in a typical SQL injection attack an attacker might enter
 * his User ID as <br>&#010 &nbsp;&nbsp;<code>123' OR '1' = '1</code><p>&#010 in the hope that this will generate a
 * query&#010 with a where clause like this<br>&#010  &nbsp;&nbsp;<code>WHERE userID = '123' OR '1' = '1'</code><p>&#010
 * which would of course return every row.  With Smart GWT custom queries, this does not happen; &#010 the client-provided
 * string is escaped, and the resultant clause would look like this: <br>&#010 &nbsp;&nbsp;<code>WHERE userID = '123'' OR
 * ''1'' = ''1'</code><p>&#010 This clause only returns those records where the userID column contains the literal value
 * that &#010 the user typed: <br>&#010 &nbsp;&nbsp;<code>123' OR '1' = '1</code>&#010 <p>&#010 Further, custom queries can
 * be protected from buggy or ad-hoc client requests because the &#010 query is specified on the server.  For example you
 * could add a custom where clause, as shown&#010 in the above section on default clauses, to ensure that certain records
 * are never seen by&#010 the client.  For instance: <p>&#010 <code>&lt;whereClause&gt;($defaultWhereClause) AND
 * confidential = '0'&lt;/whereClause&gt;</code>.&#010&#010 <h4>Column case-sensitivity issues</h4>&#010 Different database
 * products have different rules concerning case-sensitivity in column &#010 names.  Consider the following query:&#010
 * <br><br><code>&nbsp;&nbsp;SELECT orderNumber FROM Order</code>&#010 <ul>&#010 <li>MySQL and Microsoft SQL Server are not
 * case-sensitive with regard to column names, so &#010 this query will work whether the column is called "orderNumber" or
 * "ORDERNUMBER" or any &#010 other variation.</li>&#010 <li>Oracle, HSQLDB and DB2 default to upper-case column names. 
 * Therefore, this query will&#010 fail if the column is actually called "orderNumber"; it will only work if the
 * underlying&#010 column name is "ORDERNUMBER"</li>&#010 <li>PostgreSQL defaults to lower-case column names, so this query
 * will fail unless the &#010 underlying column name is actually "ordernumber"</li>&#010 </ul>&#010 These differences are
 * one barrier to writing SQL that is portable from one database product&#010 to another.  There are two ways to work
 * around them.&#010 <p>&#010 Firstly, you can simply accept the database's default behavior.  So, your table would &#010
 * contain a column called "orderNumber" on MySQL, "ORDERNUMBER" on Oracle and "ordernumber"&#010 on PostgreSQL (note that
 * you can still use mixed-case DataSource field names; Smart GWT&#010 will map DataSource field "orderNumber" to Oracle
 * column "ORDERNUMBER" transparently). This&#010 is the simplest approach.&#010 <p>&#010 If you can't, or don't want to,
 * accept the database default - if you are working with an&#010 existing schema, for example - then you will need to quote
 * column names in your queries.&#010 Unfortunately, the way you do this also differs by database product, so quoting a
 * column&#010 name correctly in one database's syntax will mean that the query cannot be ported to a&#010 different
 * database without change.&#010 <p>&#010 To help with this case, we provide two extra container variables that you can
 * use.&#010 <b>$fields</b> contains the names of all the fields in your DataSource, but quoted in&#010 accordance with the
 * column-quoting rules of the target database.  <b>$qfields</b> also&#010 contains a list of field names, but in this case
 * each one is qualified with its table&#010 name.<p>&#010 As an example of how to use <b>$fields</b> and <b>$qfields</b>,
 * consider a DataSource with&#010 a field called "itemID", bound to a column also called "itemID", and a tableName
 * property &#010 of "orderItem".  Here are three ways to write a {@link
 * com.smartgwt.client.docs.serverds.OperationBinding#selectClause 'selectClause'} &#010 for a custom SQL query that
 * returns that field:<ul>&#010 <li><code>orderItem."itemID"</code>&#010 <li><code>orderItem.$fields.itemID</code>&#010
 * <li><code>$qfields.itemID</code>&#010 </ul>&#010 The first of these is not portable.  It will work fine in HSQL and
 * Oracle, but will fail &#010 with a syntax error in MySQL, amongst others, because you quote a field name with backticks
 * &#010 in MySQL, not quote marks.&#010 <p>&#010 The usages via <b>$fields</b> and <b>$qfields</b> <em>are</em> portable. 
 * The second line, &#010 when targeting Oracle, will be translated to <code>orderItem."itemID"</code>; when targeting&#010
 * MySQL, it will be translated to <code>orderItem.itemID</code>, or <code>orderItem.`itemID`</code>&#010 if column quoting
 * is enabled for that database (it generally isn't required, since MySQL &#010 preserves case by default).
 * @see com.smartgwt.client.docs.serverds.OperationBinding#selectClause
 * @see com.smartgwt.client.docs.serverds.OperationBinding#tableClause
 * @see com.smartgwt.client.docs.serverds.OperationBinding#whereClause
 * @see com.smartgwt.client.docs.serverds.OperationBinding#groupClause
 * @see com.smartgwt.client.docs.serverds.OperationBinding#orderClause
 * @see com.smartgwt.client.docs.serverds.OperationBinding#valuesClause
 * @see com.smartgwt.client.docs.serverds.OperationBinding#customSQL
 * @see com.smartgwt.client.docs.serverds.OperationBinding#customHQL
 * @see com.smartgwt.client.docs.serverds.OperationBinding#customValueFields
 * @see com.smartgwt.client.docs.serverds.OperationBinding#customCriteriaFields
 * @see com.smartgwt.client.docs.serverds.OperationBinding#excludeCriteriaFields
 * @see com.smartgwt.client.docs.serverds.OperationBinding#useForCacheSync
 * @see com.smartgwt.client.docs.serverds.OperationBinding#cacheSyncOperation
 * @see com.smartgwt.client.docs.serverds.OperationBinding#canSyncCache
 * @see com.smartgwt.client.docs.serverds.OperationBinding#sqlType
 * @see com.smartgwt.client..DefaultQueryClause
 * @see com.smartgwt.client..SQLType
 */
public interface CustomQuerying {
}
