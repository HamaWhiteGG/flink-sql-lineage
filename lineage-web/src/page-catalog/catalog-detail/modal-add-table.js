import React,{useState, useEffect} from 'react'
import { Modal, Form, Select } from 'antd'
import Monaco from 'react-monaco-editor'
import 'monaco-editor/esm/vs/basic-languages/sql/sql.contribution'
import { Base64 } from 'js-base64'

const layout = {
  labelCol: {
    span: 8,
  },
  wrapperCol: {
    span: 16,
  },
}
const {Option} = Select
const Cm = (props) => {
  const {curDatabase, databaseList} = props
  const [form] = Form.useForm()
  const [value, setValue] = useState(null)
  const _initOptions = {
    selectOnLineNumbers: true,
    renderSideBySide: false,
    lineNumbersMinChars: 3, // 最少显示3位长的行号
    lineDecorationsWidth: 20,
    quickSuggestions: true,
    renderLineDecorations: (lineNumber, decorations) => {
      return [
        {
          range: { startLineNumber: lineNumber, endLineNumber: lineNumber },
          options: {
            isWholeLine: true,
            linesDecorationsClassName: "line-decoration",
            overviewRulerLane: monaco.editor.OverviewRulerLane.Left
          }
        }
      ]
    }
  }
  const editorWillMount = () => {}

  // change monaco
  const onChangeMonaco = (val) => {
    if (value !== val ) {
      setValue(val)
    } else {
    }
  }
  const onFinish = (values) => {
    console.log(values);
  }

  useEffect(() => {
    form && form.setFieldValue('database', curDatabase)
  }, [curDatabase])

  return (
    <Modal
      {...props}
      title="Create Table"
      onOk={() => {props.onOk({ddl: Base64.encode(value), database: form.getFieldValue('database')})}}
      onCancel={() => {
        props.onCancel()
        form.resetFields()
        setValue('')
      }}
    >
      <Form
        {...layout}
        form={form}
        onFinish={onFinish}
        style={{
          maxWidth: 600,
        }}
      >
        <Form.Item
          name="database"
          label="database"
          rules={[
            {
              required: true,
            },
          ]}
        >
          <Select>
            {databaseList.map(t => <Option key={t} value={t}>{t}</Option>)}
          </Select>
        </Form.Item>
        <Monaco 
          height={300}
          value={value}
          language="sql"
          options={_initOptions}
          editorWillMount={editorWillMount}
          onChange={onChangeMonaco}
        />
      </Form>
      
    </Modal>
  )
}
export default Cm