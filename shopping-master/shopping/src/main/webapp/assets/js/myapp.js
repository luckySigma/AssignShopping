$(function() {
	// active menu
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	case 'Order Products':
		$('#orderProducts').addClass('active');
		break;
		
	default:
		if (menu == Home)
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	}

	// code for jquery DataTable

	var jsonUrl = '';
	if (window.categoryId == '') {
		jsonUrl = window.contextRoot + '/json/data/all/products';

	} else {

		jsonUrl = window.contextRoot + '/json/data/category/'
				+ window.catgortId + '/products';
	}

	var $table = $('#productListTable')
	// execute below code only where we have this table

	if ($table.length) {

		// console.log('Inside the Table');

		$table
				.DataTable({

					lengthMenu : [
							[ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records',
									'ALL Records' ] ],
					pageLength : 5,
					ajax : {

						url : jsonUrl,
						dataSrc : ''
					},

					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {

									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg"/>'
								}
							},
							{
								data : 'name'

							},
							{
								data : 'brand'

							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {

									return 'Rs:' + data
								}

							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if(data<1){
										
										return '<span style="color:red">Out Of Stock</span>';
									}
									return data;
								}

							},
							{
								data : 'id',
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary "><span class="glyphicon glyphicon-eye">View</span></a>';
									if(row.quantity  < 1){
										str += '<a href="javascript.void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart">ADD</span></a>';
									
										
									}else{
									
									str += '<a href="'
											+ window.contextRoot
											+ '/cart/add/'
											+ data
											+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart">ADD</span></a>';
									
									
									}
									return str;
								}

							},

					]
				});
	}
	// data table for admin
	
	

	var jsonUrl = '';
	

	var $adminProductsTable = $('#adminProductsTable')
	// execute below code only where we have this table

	if ($adminProductsTable.length) {
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
		// console.log('Inside the Table');

		$adminProductsTable
				.DataTable({

					lengthMenu : [
							[ 10, 20, 50, -1 ],
							[ '10 Records', '20 Records', '50 Records',
									'ALL Records' ] ],
					pageLength : 10,
					ajax : {

						url : jsonUrl,
						dataSrc : ''
					},

					columns : [
						
						
						{
							data: 'id'
							
						},	
							{
								data : 'code',
								mRender : function(data, type, row) {

									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg"/>'
								}
							},
							{
								data : 'name'

							},
							{
								data : 'brand'

							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if(data<1){
										
										return '<span style="color:red">Out Of Stock</span>';
									}
									return data;
								}

							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {

									return 'Rs:' + data
								}

							},
							{
								data : 'active',
								bSortable:false,
								mRender : function(data, type, row) {

									var str = '';
									
									str += '<label class="switch">';
									if(data){
										str += '<input type="checkbox" checked="checked" value="'+row.id+'"/>';
										
									}else{
										str += '<input type="checkbox" value="'+row.id+'"/>';
									}
									
									/*str += '<div class="slider"></div></label>';*/
									str += '<div class="slider round"></div></label>';
									
									return str;
								}

							},
							
							{
								data:'id',
								bSortable: false,
								mRender : function(data, type, row) {
									var str ='';
									str += '<a href="${contextRoot}/manage/'
										+ data
										+ '/product" class="btn btn-warning">';
										str +='<span class="glyphicon glyphicon-pencil"></span></a>';
										
										return str;
								}
								
							}

					],
					
					//render table 
					initComplete:function(){
						
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change',function(){
							
							var checkbox = $(this);
							var checked = checkbox.prop('checked');
							var dMsg = (checked)? 'You want to activate the product?':
												'You want to deactivate the product';
							var value = checkbox.prop('value');	
							
							bootbox.confirm({
								size: 'medium',
								title:'Product Activation & Deactivation',
								message: dMsg,
								callback: function(confirmed){
									
									if(confirmed){
										console.log(value);
										bootbox.alert({
											
											size: 'medium',
											title: 'Information',
											message:'You are going to perform operation on product' +value
										});
										
									}else{
										checkbox.prop('checked',!checked);
									}
								}
							});
							
							
							
							
						});
					}
					
					
					
				});
	}
	
	
	
	
	
	
	// dismissing the alert after 3 seconds
	
	var $alert =$('.alert');
	if($alert.length){
		
		setTimeot(function(){
			
			$alert.fadeOut('slow');
		},3000)
		
	}
	

	

});