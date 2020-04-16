package com.qintess.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//mapeando a classe no banco (tabela)
	@Entity
	@Table (name = "schema_version")
public class SchemaVersion implements EntidadeBase {
		//mapear esses campos para as colunas do BD
		@Id                                     //PRIMARY KEY
		@GeneratedValue(strategy = GenerationType.IDENTITY)      //autoincremento
		@Column(name = "installed_rank")
		private int codigo;
		
		@Column(name = "version")
		private String version;
		
		@Column(name = "description")
		private String description;
		
		@Column(name = "type")
		private String type;
		
		@Column(name = "script")
		private String script;
		
		@Column(name = "checksum")
		private int checksum;
		
		@Column(name = "installed_by")
		private String installedby;
		
		@Column(name = "installed_on")
		private Timestamp installedon;
		
		@Column(name = "execution_time")
		private int executiontime;
		
		@Column(name = "sucess")
		private int sucess;

		//construtor sem parametros
		public SchemaVersion() {}
		
		//construtor using fields
		public SchemaVersion(String version, String description, String type, String script, int checksum,
				String installedby, Timestamp installedon, int executiontime, int sucess) {
			this.version = version;
			this.description = description;
			this.type = type;
			this.script = script;
			this.checksum = checksum;
			this.installedby = installedby;
			this.installedon = installedon;
			this.executiontime = executiontime;
			this.sucess = sucess;
		}
		
		//Metodos de acesso e modificadores
		public int getCodigo() {
			return codigo;
		}
		public void setCodigo (int codigo) {
			this.codigo = codigo;
		}
		public String getVersion() {
			return version;
		}
		public void setVersion(String version) {
			this.version = version;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getScript() {
			return script;
		}
		public void setScript(String script) {
			this.script = script;
		}
		public int getChecksum() {
			return checksum;
		}
		public void setChecksum(int checksum) {
			this.checksum = checksum;
		}
		public String getInstalledby() {
			return installedby;
		}
		public void setInstalledby(String installedby) {
			this.installedby = installedby;
		}
		public Timestamp getInstalledon() {
			return installedon;
		}
		public void setInstalledon(Timestamp installedon) {
			this.installedon = installedon;
		}
		public int getExecutiontime() {
			return executiontime;
		}
		public void setExecutiontime(int executiontime) {
			this.executiontime = executiontime;
		}
		public int getSucess() {
			return sucess;
		}
		public void setSucess(int sucess) {
			this.sucess = sucess;
		}
		//metodo de conveniência - fins de depuracao, para que possa imprimir o objeto e obter os detalhes reais dele
				@Override
				public String toString() {
					return "SchemaVersion [installed_rank=" + codigo + ", version=" + version + ", description="
							+ description + ", type=" + type + ", script=" + script + ", checksum=" + checksum
							+ ", installed_by=" + installedby + ", installed_on=" + installedon + ", execution_time="
							+ executiontime + ", sucess=" + sucess + "]";
				}		
}
