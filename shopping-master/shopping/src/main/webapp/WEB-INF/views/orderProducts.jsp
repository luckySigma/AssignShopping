<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<div class="container">

	<div class="row">
		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismisible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>
		<div class="col-xs-12"></div>

		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Order Management</h4>

				</div>

				<div class="panel-body">
					<!-- Form Elements -->
					<sf:form class="form-horizontal" modelAttribute="order"
						action="${contextRoot}/order/orderproducts" method="POST"
						>

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
									<sf:errors path="name" cssClass="help-block" element="em"/>
							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Brand Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
									<sf:errors path="brand" cssClass="help-block" element="em"/>
							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Enter
								Quantity:</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Quantity" class="form-control" />
								<sf:errors path="quantity" cssClass="help-block" element="em"/>
							</div>

						</div>
						<div class="form-group">

							<label class="control-label col-md-4" for="unitPrice">Enter
								Unit Price:</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Unit Price" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em"/>


							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="email">Enter
								Email:</label>
							<div class="col-md-8">
								<sf:input type="text" path="email" id="email"
									placeholder="Email" class="form-control" />
								<sf:errors path="email" cssClass="help-block" element="em"/>
							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="supplier">Supplier
								Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="supplier" id="supplier"
									placeholder="Supplier Name" class="form-control" />
							<sf:errors path="supplier" cssClass="help-block" element="em"/>
							</div>

						</div>


						<div class="col-md-offset-4 form-group">

							<div class="col-md-8">
								<input type="submit" name="submit" id="submit"
									class="btn btn-primary" />
								<!-- Hidden Field For order -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />

								<sf:hidden path="active" />

							</div>

						</div>


						<%-- <!-- update -->
						
						<div class="col-md-offset-4 form-group">

							<div class="col-md-8">
								<input type="submit" name="update" id="update" value="Update"
									class="btn btn-primary" />
								<!-- Hidden Field For order -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />

								<sf:hidden path="active" />

							</div>

						</div>
 --%>

					</sf:form>
				</div>



			</div>

		</div>

	</div>


</div>