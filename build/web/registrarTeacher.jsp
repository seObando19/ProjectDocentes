<%-- 
    Document   : registrarVehi
    Created on : 04-sep-2019, 21:02:52
    Author     : sebas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Gestion de Docentes</title>

		<meta name="description" content="Wilson Castro Gil" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
                <%@include file="csstemplate.jsp" %>
	</head>

	<body class="no-skin">
		<%@include file="incluidos/header.jsp" %>

		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>

			<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
				<script type="text/javascript">
					try{ace.settings.loadState('sidebar')}catch(e){}
				</script>

				<%@include file="incluidos/iconosNavBar.jsp" %>

				<%@include file="incluidos/listaNavBar.jsp" %>

				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
			</div>

			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Inicio</a>
							</li>

							
						</ul><!-- /.breadcrumb -->

						<div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
							</form>
						</div><!-- /.nav-search -->
					</div>

					<div class="page-content">
						<div class="ace-settings-container" id="ace-settings-container">
							<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
								<i class="ace-icon fa fa-cog bigger-130"></i>
							</div>

							<div class="ace-settings-box clearfix" id="ace-settings-box">
								<div class="pull-left width-50">
									<div class="ace-settings-item">
										<div class="pull-left">
											<select id="skin-colorpicker" class="hide">
												<option data-skin="no-skin" value="#438EB9">#438EB9</option>
												<option data-skin="skin-1" value="#222A2D">#222A2D</option>
												<option data-skin="skin-2" value="#C6487E">#C6487E</option>
												<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
											</select>
										</div>
										<span>&nbsp; Choose Skin</span>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-navbar" autocomplete="off" />
										<label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-sidebar" autocomplete="off" />
										<label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-breadcrumbs" autocomplete="off" />
										<label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" autocomplete="off" />
										<label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-add-container" autocomplete="off" />
										<label class="lbl" for="ace-settings-add-container">
											Inside
											<b>.container</b>
										</label>
									</div>
								</div><!-- /.pull-left -->

								<div class="pull-left width-50">
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" autocomplete="off" />
										<label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact" autocomplete="off" />
										<label class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight" autocomplete="off" />
										<label class="lbl" for="ace-settings-highlight"> Alt. Active Item</label>
									</div>
								</div><!-- /.pull-left -->
							</div><!-- /.ace-settings-box -->
						</div><!-- /.ace-settings-container -->

						<div class="page-header">
							<h1>
								Gestionar los Docentes
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
                                                                Registrar Docentes
								</small>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<!-- /.row -->

								<div class="row">
									<div class="col-xs-12">
										<div class="table-header">
											Resultados de Docentes
										</div>

										<!-- div.table-responsive -->

										<!-- div.dataTables_borderWrap -->
                                                                                <div>
                                                                                    <br><br>
                                                                                    <form action="teacher" method="post" class="form-horizontal">
                                                                                        <div class="form-group">
                                                                                            <label class="col-sm-3 control-label no-padding-right">
                                                                                                Cedula docente
                                                                                            </label>
                                                                                            <div class="col-sm-9">
                                                                                                <input type="text" name="txtCedula" maxlength="10" placeholder="Ingrese Cedula">
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="form-group">
                                                                                            <label class="col-sm-3 control-label no-padding-right">
                                                                                                Nombre docente
                                                                                            </label>
                                                                                            <div class="col-sm-9">
                                                                                                <input type="text" name="txtNombre" value="" placeholder="Ingrese nombre">
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="form-group">
                                                                                            <label class="col-sm-3 control-label no-padding-right">
                                                                                                Ingrese Avatar
                                                                                            </label>
                                                                                            <div class="col-sm-9">
                                                                                                <input type="file" name="txtAvatar">
                                                                                            </div>
                                                                                        </div>                                                                                        
                                                                                        <button name="accion" class="btn btn-success" type="submit" value="registrar">
                                                                                            <i class="fa fa-save"> Registrar</i>
                                                                                        </button>
                                                                                        <button name="accion" class="btn btn-warning" type="submit" value="actualizar">
                                                                                            <i class="fa fa-edit"> Actualizar</i>
                                                                                        </button>
                                                                                        <button  name="accion" class="btn btn-danger" type="submit" value="eliminar">
                                                                                            <i class="fa fa-clock-o"> Eliminar</i>
                                                                                        </button>                                                                                             
                                                                                                <div>
                                                                                                    <%=(request.getAttribute("mensaje") !=null? request.getAttribute("mensaje"):"")%>
                                                                                                </div>
                                                                                    </form>
											
                                                                                </div>
										</div><!-- /.modal-content -->
									</div><!-- /.modal-dialog -->
								</div>

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

            <%@include file="incluidos/footer.jsp" %>			
            <%@include file="incluidos/Js.jsp" %>
	</body>
</html>
