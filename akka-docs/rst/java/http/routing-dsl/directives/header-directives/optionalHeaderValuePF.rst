.. _-optionalHeaderValuePF-java-:

optionalHeaderValuePF
=====================

Description
-----------
Calls the specified partial function with the first request header the function is ``isDefinedAt`` and extracts the
result of calling the function.

The ``optionalHeaderValuePF`` directive is similar to the :ref:`-headerValuePF-java-` directive but always extracts an ``Optional``
value instead of rejecting the request if no matching header could be found.

Example
-------
TODO: Example snippets for JavaDSL are subject to community contributions! Help us complete the docs, read more about it here: `write example snippets for Akka HTTP Java DSL #20466 <https://github.com/akka/akka/issues/20466>`_.
